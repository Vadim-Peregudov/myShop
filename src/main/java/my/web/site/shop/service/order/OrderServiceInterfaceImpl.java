package my.web.site.shop.service.order;

import my.web.site.shop.model.client.Client;
import my.web.site.shop.model.order.Order;
import my.web.site.shop.repository.order.OrderRepository;
import my.web.site.shop.inerf.order.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceInterfaceImpl implements OrderServiceInterface {
    @Autowired
    private OrderRepository repository;

    @Override
    public void addServiceElement(Order order) {
        if (repository.findAll().contains(order)) {
            repository.save(order);
        }
    }

    @Override
    public Order getServiceElement(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new NullPointerException("This basket by ID is NULL");
    }

    @Override
    public boolean updateServiceElement(Long id, Order order) {
        if (repository.existsById(id)) {
            var oldBasket = repository.findById(id).get();
            oldBasket.setClient(order.getClient());
            oldBasket.setCountProduct(order.getCountProduct());
            oldBasket.setOrderStatusComplete(order.getOrderStatusComplete());
            oldBasket.setProductId(order.getProductId());
            oldBasket.setCategoryId(order.getCategoryId());
            repository.save(oldBasket);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteServiceElement(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public void saveAllElements(Iterable<Order> iterable) {
        repository.saveAll(iterable);
    }

    @Override
    public List<Order> getListAllElements() {
        return repository.findAll();
    }

    @Override
    public List<Order> getListOrderByClient(Client client) {
        return repository.findByClient(client);
    }

    @Override
    public void deleteOrdersByCategoryIdAndProductId(Long categoryId, Long productId) {
        repository.deleteByCategoryIdAndProductIdAllIgnoreCase(categoryId, productId);
    }
}
