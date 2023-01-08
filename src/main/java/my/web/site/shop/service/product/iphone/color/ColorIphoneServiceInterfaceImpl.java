package my.web.site.shop.service.product.iphone.color;

import my.web.site.shop.model.products.phone.color.ColorIphone;
import my.web.site.shop.repository.product.iphone.color.ColorIphoneRepository;
import my.web.site.shop.inerf.product.iphone.color.ColorIphoneServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorIphoneServiceInterfaceImpl implements ColorIphoneServiceInterface {
    @Autowired
    private ColorIphoneRepository repository;

    @Override
    public void addServiceElement(ColorIphone colorIphone) {
        if (!repository.findAll().contains(colorIphone)) {
            repository.save(colorIphone);
        }
    }


    @Override
    public ColorIphone getServiceElement(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new NullPointerException("");
    }

    @Override
    public boolean updateServiceElement(Long id, ColorIphone newColorIphone) {
        if (repository.existsById(id)) {
            var color = repository.findById(id).get();
            color.setColor(newColorIphone.getColor());
            repository.save(color);
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
    public ColorIphone getElementByName(String name) {
        var color = repository.findByColorIgnoreCase(name);
        if (color.isPresent()) {
            return color.get();
        }
        throw new NullPointerException("color is null");
    }

    @Override
    public List<ColorIphone> getListAllElements() {
        return repository.findAll();
    }
}
