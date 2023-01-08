package my.web.site.shop.service.product.iphone.memory;

import my.web.site.shop.model.products.phone.memory.MemorySizeIphone;
import my.web.site.shop.repository.product.iphone.memory.MemorySizeRepository;
import my.web.site.shop.inerf.product.iphone.memory.MemorySizeIphoneServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemorySizeIphoneServiceInterfaceImpl implements MemorySizeIphoneServiceInterface {
    @Autowired
    private MemorySizeRepository repository;

    @Override
    public void addServiceElement(MemorySizeIphone memorySizeIphone) {
        if (!repository.findAll().contains(memorySizeIphone)) {
            repository.save(memorySizeIphone);
        }
    }

    @Override
    public MemorySizeIphone getServiceElement(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new NullPointerException("This product by id is null");
    }

    @Override
    public boolean updateServiceElement(Long id, MemorySizeIphone memorySizeIphone) {
        if (repository.existsById(id)) {
            var memory = repository.findById(id).get();
            memory.setSize(memorySizeIphone.getSize());
            repository.save(memory);
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
    public List<MemorySizeIphone> getListAllElements() {
        return repository.findAll();
    }

    @Override
    public MemorySizeIphone getElementByName(String name) {
        var memory = repository.findBySizeIgnoreCase(name);
        if (memory.isPresent()) {
            return memory.get();
        }
        throw new NullPointerException("null memory");
    }
}
