package my.web.site.shop.inerf.product.watch;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.get.save.list.GelListByNameInterface;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;
import my.web.site.shop.model.products.watch.ProductWatch;

public interface ProductWatchServiceInterface extends CRUDServiceInterface<ProductWatch>,
        GetListAllElementInterface<ProductWatch>, GelListByNameInterface<ProductWatch> {
}
