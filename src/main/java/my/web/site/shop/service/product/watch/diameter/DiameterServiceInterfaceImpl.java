package my.web.site.shop.service.product.watch.diameter;

import my.web.site.shop.inerf.product.watch.diameter.DiameterServiceInterface;
import my.web.site.shop.model.products.watch.diameter.WatchDiameter;
import my.web.site.shop.repository.product.watch.diameter.DiameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiameterServiceInterfaceImpl implements DiameterServiceInterface {
    @Autowired
    private DiameterRepository repository;

    @Override
    public void addServiceElement(WatchDiameter watchDiameter) {
        if(!repository.findAll().contains(watchDiameter)){
            repository.save(watchDiameter);
        }
    }

    @Override
    public WatchDiameter getServiceElement(Long id) {
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }
        throw new NullPointerException("This diameter by id is null");
    }

    @Override
    public boolean updateServiceElement(Long id, WatchDiameter watchDiameter) {
        if (repository.existsById(id)){
            var product = repository.findById(id).get();
            product.setDiameter(watchDiameter.getDiameter());
            repository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteServiceElement(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<WatchDiameter> getSetAllElements() {
        return new LinkedHashSet<>(repository.findAll());
    }

    @Override
    public List<WatchDiameter> getListAllElements() {
        return repository.findAll();
    }
}
