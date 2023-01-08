package my.web.site.shop.model.basket;

import my.web.site.shop.model.products.Product;
import my.web.site.shop.model.products.phone.ProductIphone;
import my.web.site.shop.model.products.watch.ProductWatch;

public class BasketCostCalculation {
    public static Integer calcBasket (Basket basket){
        var mapList = basket.getBasket();

        int sum = 0;

        for(Product product : mapList.keySet()){
            if (product instanceof ProductIphone){
                sum += ((ProductIphone) product).getPrise()*mapList.get(product);
            } else if (product instanceof ProductWatch){
                sum += ((ProductWatch) product).getPrise() * mapList.get(product);
            }
        }

        return sum;
    }


}
