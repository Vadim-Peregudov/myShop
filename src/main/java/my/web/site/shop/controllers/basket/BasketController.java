package my.web.site.shop.controllers.basket;

import my.web.site.shop.inerf.categorys.CategoryProductServiceInterface;
import my.web.site.shop.inerf.product.watch.ProductWatchServiceInterface;
import my.web.site.shop.model.basket.Basket;
import my.web.site.shop.model.basket.BasketCostCalculation;
import my.web.site.shop.model.basket.UpdateBasket;
import my.web.site.shop.inerf.product.iphone.ProductIphoneServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class BasketController {

    @Autowired
    private ProductIphoneServiceInterface serviceIphone;

    @Autowired
    private ProductWatchServiceInterface serviceWatch;
    @Autowired
    private CategoryProductServiceInterface serviceCategory;

    @GetMapping("/basket/add/{categoryId}/{productId}")
    public String allProductInBasket(@PathVariable("categoryId") Long categoryId,
                                     @PathVariable("productId") Long productId, Model model, HttpSession session) {

        Basket basket = new Basket(session);

        if (equalsIsCategory(categoryId,"iphone")) {
            UpdateBasket.addProductBasket(basket, serviceIphone.getServiceElement(productId));
        } else if (equalsIsCategory(categoryId,"watch")) {
            UpdateBasket.addProductBasket(basket, serviceWatch.getServiceElement(productId));
        }

        session.setAttribute("basket", basket.getBasket());
        return "redirect:/basket";
    }

    private boolean equalsIsCategory (Long categoryId, String category) {
        return serviceCategory.getServiceElement(categoryId).getCategory().equalsIgnoreCase(category);
    }

    @GetMapping("/basket")
    public String showAllProductInBasket(Model model, HttpSession session) {
        Basket basket = new Basket(session);
        int priceItemsInBasket = BasketCostCalculation.calcBasket(basket);
        model.addAttribute("priceItemsInBasket", priceItemsInBasket);
        return "basketUser";
    }

    @GetMapping("/basket/delete/{categoryId}/{productId}")
    public String deleteProductInBasket(@PathVariable("categoryId") Long categoryId,
                                        @PathVariable("productId") Long productId, Model model, HttpSession session) {
        Basket basket = new Basket(session);

        if (equalsIsCategory(categoryId,"iphone")) {
            UpdateBasket.deleteProductInBasket(basket, serviceIphone.getServiceElement(productId));
        } else if (equalsIsCategory(categoryId,"watch")) {
            UpdateBasket.deleteProductInBasket(basket, serviceWatch.getServiceElement(productId));
        }
        session.setAttribute("basket", basket.getBasket());
        return "redirect:/basket";
    }

    @GetMapping("/basket/reduce/{categoryId}/{productId}")
    public String reduceProductInBasket(@PathVariable("categoryId") Long categoryId,
                                        @PathVariable("productId") Long productId, Model model, HttpSession session) {

        Basket basket = new Basket(session);
        if (equalsIsCategory(categoryId,"iphone")) {
            UpdateBasket.reduceProductInBasket(basket, serviceIphone.getServiceElement(productId));
        } else if (equalsIsCategory(categoryId,"watch")) {
            UpdateBasket.reduceProductInBasket(basket, serviceWatch.getServiceElement(productId));
        }
        return "redirect:/basket";
    }


}
