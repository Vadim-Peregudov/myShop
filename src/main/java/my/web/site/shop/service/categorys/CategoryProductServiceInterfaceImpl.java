package my.web.site.shop.service.categorys;

import my.web.site.shop.model.categories.CategoryProduct;
import my.web.site.shop.repository.category.CategoryProductRepository;
import my.web.site.shop.inerf.categorys.CategoryProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductServiceInterfaceImpl implements CategoryProductServiceInterface {
    @Autowired
    private CategoryProductRepository repository;

    @Override
    public void addServiceElement(CategoryProduct categoryProduct) {
        if (!repository.findAll().contains(categoryProduct)) {
            repository.save(categoryProduct);
        }
    }

    @Override
    public CategoryProduct getServiceElement(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new NullPointerException("This product by id is null");
    }

    @Override
    public boolean updateServiceElement(Long id, CategoryProduct categoryProduct) {
        if (repository.existsById(id)) {
            var category = repository.findById(id).get();
            category.setCategory(categoryProduct.getCategory());
            repository.save(categoryProduct);
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
    public List<CategoryProduct> getListAllElements() {
        return repository.findAll();
    }


    @Override
    public CategoryProduct getElementByName(String name) {
        var category = repository.findByCategoryIgnoreCase(name);
        if (category.isPresent()) {
            return category.get();
        }
        throw new NullPointerException("This category by " + name + " is null");
    }
}
