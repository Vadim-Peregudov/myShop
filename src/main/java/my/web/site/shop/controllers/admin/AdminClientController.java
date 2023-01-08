package my.web.site.shop.controllers.admin;

import my.web.site.shop.inerf.crud.client.ClientServiceInterface;
import my.web.site.shop.inerf.order.OrderServiceInterface;
import my.web.site.shop.model.basket.Basket;
import my.web.site.shop.model.basket.CreateBasketByListOrder;
import my.web.site.shop.model.client.Client;
import my.web.site.shop.model.client.OrdersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminClientController {
    @Autowired
    private ClientServiceInterface serviceClient;
    @Autowired
    private CreateBasketByListOrder createBasket;
    @Autowired
    private OrderServiceInterface serviceOrder;

    @GetMapping("/client")
    public String adminShowAllClient(Model model) {
        HashMap<Client, List<OrdersClient>> listClientDateTime = createListClientOrder();
        System.out.println(listClientDateTime);

        return "admin/adminClients";
    }

    private HashMap<Client, List<OrdersClient>> createListClientOrder (){
        LinkedHashMap<Client, List<OrdersClient>> listClientDateTime =new LinkedHashMap<>();
        var listAllClients = serviceClient.getListAllElements();
        for (Client client : listAllClients) {
            var orderClientList = createOrderClientList(client);
            listClientDateTime.put(client, orderClientList);
        }

        return listClientDateTime;
    }

    private ArrayList<OrdersClient> createOrderClientList (Client client){
        var listClient = serviceClient.getListClientByNameAndEmailAndPhone(client);
        ArrayList<OrdersClient> orderClientList = new ArrayList<>();
        for(Client c:listClient){
            OrdersClient ordersClient = new OrdersClient();
            ordersClient.setTimeOrder(c.getDateOrder());
            ordersClient.setCommentToOrder(c.getCommentToOrder());

            Basket basket = createBasket.createAndGet(serviceOrder.getListOrderByClient(c));

            ordersClient.setBasketClient(basket);
            orderClientList.add(ordersClient);
        }
        return orderClientList;
    }


}
