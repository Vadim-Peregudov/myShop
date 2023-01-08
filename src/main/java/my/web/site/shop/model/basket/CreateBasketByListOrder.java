package my.web.site.shop.model.basket;

import my.web.site.shop.inerf.product.iphone.ProductIphoneServiceInterface;
import my.web.site.shop.inerf.product.watch.ProductWatchServiceInterface;
import my.web.site.shop.model.categories.Categories;
import my.web.site.shop.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CreateBasketByListOrder {
    @Autowired
    private ProductIphoneServiceInterface serviceIphone;
    @Autowired
    private  ProductWatchServiceInterface serviceWatch;

    public  Basket createAndGet(List<Order> orders) {
        Basket basketClient = new Basket();
        for (Order order : orders) {
            if (order.getCategoryId().getCategory().equalsIgnoreCase(Categories.IPHONE.getCategory())) {
                basketClient.getBasket().put(serviceIphone.getServiceElement(order.getProductId()), Math.toIntExact(order.getCountProduct()));
            } else if (order.getCategoryId().getCategory().equalsIgnoreCase(Categories.WATCH.getCategory())){
                basketClient.getBasket().put(serviceWatch.getServiceElement(order.getProductId()), Math.toIntExact(order.getCountProduct()));
            }
        }
        return basketClient;
    }
}
