package my.web.site.shop.model.basket;

import my.web.site.shop.model.products.Product;

public class UpdateBasket {
    public static Basket addProductBasket(Basket basket, Product addProduct) {
         if (basket.getBasket().containsKey(addProduct)) {
             basket.getBasket().put(addProduct, basket.getBasket().get(addProduct) + 1);
         } else {
             basket.getBasket().put(addProduct, 1);
         }
        return basket;
    }
    public static Basket deleteProductInBasket(Basket basket, Product deleteProduct){
        basket.getBasket().remove(deleteProduct);
        return basket;
    }
    public static  Basket reduceProductInBasket (Basket basket, Product deleteProduct){
        if (basket.getBasket().containsKey(deleteProduct)){
            if (basket.getBasket().get(deleteProduct)>1){
                basket.getBasket().put(deleteProduct, basket.getBasket().get(deleteProduct) - 1);
            }
        }
        return basket;
    }

    public static  Basket clearProductInBasket (Basket basket){
        basket.getBasket().clear();
        return basket;
    }

}
