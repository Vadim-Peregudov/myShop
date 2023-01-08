package my.web.site.shop.inerf.product.iphone.color;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.get.GetElementByNameInterface;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;
import my.web.site.shop.model.products.phone.color.ColorIphone;

public interface ColorIphoneServiceInterface extends CRUDServiceInterface<ColorIphone>, GetListAllElementInterface<ColorIphone>, GetElementByNameInterface<ColorIphone> {
}
