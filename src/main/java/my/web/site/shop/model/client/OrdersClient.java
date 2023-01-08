package my.web.site.shop.model.client;

import my.web.site.shop.model.basket.Basket;
import my.web.site.shop.model.products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class OrdersClient {
    private LocalDateTime timeOrder;
    private String commentToOrder;
    private Basket basketClient;

    public OrdersClient() {
    }

    public LocalDateTime getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(LocalDateTime timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getCommentToOrder() {
        return commentToOrder;
    }

    public void setCommentToOrder(String commentToOrder) {
        this.commentToOrder = commentToOrder;
    }

    public Basket getBasketClient() {
        return basketClient;
    }

    public void setBasketClient(Basket basketClient) {
        this.basketClient = basketClient;
    }
}
