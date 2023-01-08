package my.web.site.shop.service.product.status;

import my.web.site.shop.model.products.status.StatusProduct;
import my.web.site.shop.repository.product.status.StatusRepository;
import my.web.site.shop.inerf.product.status.StatusServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceInterfaceImpl implements StatusServiceInterface {
    @Autowired
    private StatusRepository repository;

    @Override
    public void addServiceElement(StatusProduct statusProduct) {
        if (repository.findAll().contains(statusProduct)) {
            repository.save(statusProduct);
        }
    }

    @Override
    public StatusProduct getServiceElement(Long id) {
        var optionalStatus = repository.findById(id);
        if (optionalStatus.isPresent()) {
            return optionalStatus.get();
        }
        throw new NullPointerException("This status is null");
    }

    @Override
    public boolean updateServiceElement(Long id, StatusProduct newStatusProduct) {
        if (repository.existsById(id)) {
            var status = repository.findById(id).get();
            status.setStatus(newStatusProduct.getStatus());
            repository.save(status);
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
    public List<StatusProduct> getListAllElements() {
        return repository.findAll();
    }
}
