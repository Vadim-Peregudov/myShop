package my.web.site.shop.inerf.product.watch.diameter;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;
import my.web.site.shop.inerf.get.set.GetSetAllElementInterface;
import my.web.site.shop.model.products.watch.diameter.WatchDiameter;

public interface DiameterServiceInterface extends CRUDServiceInterface<WatchDiameter>, GetSetAllElementInterface<WatchDiameter>, GetListAllElementInterface<WatchDiameter> {
}
