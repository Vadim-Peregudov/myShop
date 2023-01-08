package my.web.site.shop.inerf.product.watch.color;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;
import my.web.site.shop.inerf.get.set.GetSetAllElementInterface;
import my.web.site.shop.model.products.watch.color.ColorWatch;

public interface ColorWatchServiceInterface extends CRUDServiceInterface<ColorWatch>,
        GetSetAllElementInterface<ColorWatch>,
        GetListAllElementInterface<ColorWatch> {
}
