package my.web.site.shop.inerf.product.status;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;
import my.web.site.shop.model.products.status.StatusProduct;

public interface StatusServiceInterface extends CRUDServiceInterface<StatusProduct>, GetListAllElementInterface<StatusProduct> {
}
