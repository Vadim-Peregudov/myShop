package my.web.site.shop.controllers.order;

import my.web.site.shop.inerf.order.OrderServiceInterface;
import my.web.site.shop.inerf.crud.client.ClientServiceInterface;
import my.web.site.shop.model.basket.Basket;
import my.web.site.shop.model.basket.BasketCostCalculation;
import my.web.site.shop.model.basket.UpdateBasket;
import my.web.site.shop.model.order.CreateOrders;
import my.web.site.shop.model.client.Client;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class OrderController {
    @Autowired
    private OrderServiceInterface serviceOrder;
    @Autowired
    private ClientServiceInterface serviceUser;


    @GetMapping("/order")
    public String showOrderForm(@ModelAttribute("client") Client client, HttpSession session, @NotNull Model model) {
        model.addAttribute("title", "Оформление заказа");
        model.addAttribute("priceItemsInBasket", BasketCostCalculation.calcBasket(new Basket(session)));
        return "orderForm";
    }

    @PostMapping("/order/create")
    public String createOrder(@ModelAttribute("client") @Valid Client client,
                              BindingResult bindingResult,
                              HttpServletRequest request, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("priceItemsInBasket", BasketCostCalculation.calcBasket(new Basket(request.getSession())));
            return "orderForm";
        }

        Basket basket = new Basket(request.getSession());

        client.setDateOrder(LocalDateTime.now());
        client = serviceUser.saveAndGetServiceElement(client);

        var orderList = CreateOrders.createAndGetOrders(basket, client);
        serviceOrder.saveAllElements(orderList);

        return "redirect:/order/status";
    }

    @GetMapping("/order/status")
    public String showOrderStatus (HttpSession session){
        UpdateBasket.clearProductInBasket(new Basket(session));
        return "orderStatus";
    }


}
