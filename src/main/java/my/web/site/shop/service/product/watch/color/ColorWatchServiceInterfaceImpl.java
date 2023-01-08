package my.web.site.shop.service.product.watch.color;

import my.web.site.shop.model.products.watch.color.ColorWatch;
import my.web.site.shop.repository.product.watch.color.ColorWatchRepository;
import my.web.site.shop.inerf.product.watch.color.ColorWatchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ColorWatchServiceInterfaceImpl implements ColorWatchServiceInterface {
    @Autowired
    private ColorWatchRepository repository;

    @Override
    public void addServiceElement(ColorWatch colorWatch) {
        if (!repository.findAll().contains(colorWatch)) {
            repository.save(colorWatch);
        }
    }

    @Override
    public ColorWatch getServiceElement(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new NullPointerException("This product by id is null");
    }

    @Override
    public boolean updateServiceElement(Long id, ColorWatch newColorWatch) {
        if (repository.existsById(id)) {
            var colorWatch = repository.findById(id).get();
            colorWatch.setColor(newColorWatch.getColor());
            repository.save(colorWatch);
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
    public Set<ColorWatch> getSetAllElements() {
        return new LinkedHashSet<>(repository.findAll());
    }

    @Override
    public List<ColorWatch> getListAllElements() {
        return repository.findAll();
    }
}
