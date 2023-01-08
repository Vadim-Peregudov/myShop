package my.web.site.shop.model.categories;

import my.web.site.shop.inerf.categorys.CategoryProductServiceInterface;
import my.web.site.shop.model.products.Product;
import my.web.site.shop.model.products.phone.ProductIphone;
import my.web.site.shop.model.products.watch.ProductWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCategoryByClassProduct {
    @Autowired
    private CategoryProductServiceInterface serviceCategory;

    public CategoryProduct get(Class<? extends Product> clazz) {
        if (clazz.equals(ProductIphone.class)) {
            return serviceCategory.getElementByName(Categories.IPHONE.getCategory());
        } else if (clazz.equals(ProductWatch.class)) {
            return serviceCategory.getElementByName(Categories.WATCH.getCategory());
        }
        throw new NullPointerException("this category by " + clazz + " class is null");
    }

}
