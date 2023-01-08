package my.web.site.shop.service.product.iphone;


import my.web.site.shop.model.products.phone.ProductIphone;
import my.web.site.shop.repository.product.iphone.ProductIphoneRepository;
import my.web.site.shop.inerf.product.iphone.ProductIphoneServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductIphoneServiceInterfaceImpI implements ProductIphoneServiceInterface {
    @Autowired
    private ProductIphoneRepository repository;


    @Override
    public void addServiceElement(ProductIphone productIphone) {
        if (!repository.findAll().contains(productIphone)) {
            repository.save(productIphone);
        }
    }

    @Override
    public ProductIphone getServiceElement(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        } else {
            throw new NullPointerException("This product by id is null");
        }
    }

    @Override
    public boolean updateServiceElement(Long id, ProductIphone newIphone) {
        if (repository.existsById(id)) {
            var oldIphone = repository.findById(id).get();
            oldIphone.setCategory(newIphone.getCategory());
            oldIphone.setColor(newIphone.getColor());
            oldIphone.setSize(newIphone.getSize());
            oldIphone.setInfo(newIphone.getInfo());
            oldIphone.setImage(newIphone.getImage());
            oldIphone.setName(newIphone.getName());
            oldIphone.setPrise(newIphone.getPrise());
            oldIphone.setStatusProduct(newIphone.getStatusProduct());
            repository.save(oldIphone);
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
    public List<ProductIphone> getListAllElements() {
        return repository.findAll();
    }


    @Override
    public ProductIphone getPhoneByNameAndColorAndSize(String name, String color, String size) {
        var phone = repository.findFirstByNameIgnoreCaseAndSize_SizeIgnoreCaseAndColor_ColorIgnoreCase(name, size, color);
        if (phone.isPresent()) {
            return phone.get();
        } else {
            throw new NullPointerException("This phone according to the specified parameters is null");
        }
    }

    @Override
    public List<ProductIphone> getListElementByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

    @Override
    public List<ProductIphone> getListProductBySizeAndName(String name, String size) {
        return repository.findByNameIgnoreCaseAndSize_SizeIgnoreCase(name, size);
    }
}
