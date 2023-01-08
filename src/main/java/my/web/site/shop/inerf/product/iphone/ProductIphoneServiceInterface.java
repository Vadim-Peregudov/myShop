package my.web.site.shop.inerf.product.iphone;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.model.products.phone.ProductIphone;
import my.web.site.shop.inerf.get.GelPhoneByNameAndColorAndSizeInterface;
import my.web.site.shop.inerf.get.GetListProductBySizeAndNameInterface;
import my.web.site.shop.inerf.get.save.list.GelListByNameInterface;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;

public interface ProductIphoneServiceInterface extends CRUDServiceInterface<ProductIphone>,
        GetListAllElementInterface<ProductIphone>,
        GelPhoneByNameAndColorAndSizeInterface<ProductIphone>,
        GelListByNameInterface<ProductIphone>,
        GetListProductBySizeAndNameInterface<ProductIphone> {

}
