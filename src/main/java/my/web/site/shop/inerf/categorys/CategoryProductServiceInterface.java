package my.web.site.shop.inerf.categorys;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.get.GetElementByNameInterface;
import my.web.site.shop.model.categories.CategoryProduct;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;

public interface CategoryProductServiceInterface extends CRUDServiceInterface<CategoryProduct>, GetListAllElementInterface<CategoryProduct>,
        GetElementByNameInterface<CategoryProduct> {
}
