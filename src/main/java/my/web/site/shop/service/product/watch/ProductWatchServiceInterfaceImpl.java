package my.web.site.shop.service.product.watch;

import my.web.site.shop.model.products.watch.ProductWatch;
import my.web.site.shop.repository.product.watch.ProductWatchRepository;
import my.web.site.shop.inerf.product.watch.ProductWatchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductWatchServiceInterfaceImpl implements ProductWatchServiceInterface {
    @Autowired
    private ProductWatchRepository repository;

    @Override
    public void addServiceElement(ProductWatch productWatch) {
        if (!repository.findAll().contains(productWatch)) {
            repository.save(productWatch);
        }
    }

    @Override
    public ProductWatch getServiceElement(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new NullPointerException("This product by id is null");
    }

    @Override
    public boolean updateServiceElement(Long id, ProductWatch newProductWatch) {
        if (repository.existsById(id)) {
            var watch = repository.findById(id).get();
            watch.setCategory(newProductWatch.getCategory());
            watch.setInfo(newProductWatch.getInfo());
            watch.setImage(newProductWatch.getImage());
            watch.setName(newProductWatch.getName());
            watch.setColorBody(newProductWatch.getColorBody());
            watch.setPrise(newProductWatch.getPrise());
            watch.setWatchDiameter(newProductWatch.getWatchDiameter());
            repository.save(watch);
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
    public List<ProductWatch> getListAllElements() {
        return repository.findAll();
    }

    @Override
    public List<ProductWatch> getListElementByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

}
