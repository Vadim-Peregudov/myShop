package my.web.site.shop.model.order;

import my.web.site.shop.model.basket.Basket;
import my.web.site.shop.model.basket.BasketCostCalculation;
import my.web.site.shop.model.products.Product;
import my.web.site.shop.model.client.Client;

import java.util.ArrayList;

public class CreateOrders {
    public static ArrayList<Order> createAndGetOrders (Basket basket, Client client){
        ArrayList<Order> orders = new ArrayList<>();

        for(Product product : basket.getBasket().keySet()){
            Order order = new Order(client,
                    product.getCategory(),
                    product.getId(),
                    (long)basket.getBasket().get(product),
                    false,
                    Long.valueOf(BasketCostCalculation.calcBasket(basket)));
            orders.add(order);
        }

        return orders;
    }
}
