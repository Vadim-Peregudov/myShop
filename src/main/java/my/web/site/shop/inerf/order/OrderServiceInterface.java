package my.web.site.shop.inerf.order;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.delete.DeleteOrderByCategoryIdAndProductId;
import my.web.site.shop.inerf.get.GetListOrderByClient;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;
import my.web.site.shop.service.order.saveAll.SaveAllElementsInterface;
import my.web.site.shop.model.order.Order;

public interface OrderServiceInterface extends CRUDServiceInterface<Order>,
        SaveAllElementsInterface<Order>,
        GetListAllElementInterface<Order>,
        GetListOrderByClient,
        DeleteOrderByCategoryIdAndProductId {
}
