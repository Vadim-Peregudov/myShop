package my.web.site.shop.inerf.product.iphone.memory;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.get.GetElementByNameInterface;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;
import my.web.site.shop.model.products.phone.memory.MemorySizeIphone;

public interface MemorySizeIphoneServiceInterface extends CRUDServiceInterface<MemorySizeIphone>, GetListAllElementInterface<MemorySizeIphone>, GetElementByNameInterface<MemorySizeIphone> {
}
