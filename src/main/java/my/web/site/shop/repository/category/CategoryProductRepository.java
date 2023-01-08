package my.web.site.shop.repository.category;


import my.web.site.shop.model.categories.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {
    Optional<CategoryProduct> findByCategoryIgnoreCase(String category);


}
