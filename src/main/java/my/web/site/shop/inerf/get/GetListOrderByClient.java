package my.web.site.shop.inerf.get;

import my.web.site.shop.model.client.Client;
import my.web.site.shop.model.order.Order;

import java.util.List;

public interface GetListOrderByClient {
    public List<Order> getListOrderByClient(Client client);
}
