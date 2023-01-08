package my.web.site.shop.model.basket;

import my.web.site.shop.model.products.Product;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;


public class Basket {
    private Long orderNumber;
    private LinkedHashMap<Product, Integer> basket;

    public Basket() {
        this.basket = new LinkedHashMap<>();
    }

    public Basket(LinkedHashMap<Product, Integer> basket) {
        if (basket == null) {
            this.basket = new LinkedHashMap<>();
        } else {
            this.basket = basket;
        }
    }

    public Basket(HttpSession session) {
        LinkedHashMap<Product, Integer> basket = (LinkedHashMap<Product, Integer>) session.getAttribute("basket");
        if (basket == null) {
            this.basket = new LinkedHashMap<>();
        } else {
            this.basket = basket;
        }
    }

    public LinkedHashMap<Product, Integer> getBasket() {
        return basket;
    }

    public void setBasket(LinkedHashMap<Product, Integer> basket) {
        this.basket = basket;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
