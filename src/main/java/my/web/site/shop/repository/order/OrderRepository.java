package my.web.site.shop.repository.order;

import my.web.site.shop.model.categories.CategoryProduct;
import my.web.site.shop.model.client.Client;
import my.web.site.shop.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByClient(Client client);
    void deleteByCategoryIdAndProductIdAllIgnoreCase(Long categoryId, Long productId);


}
