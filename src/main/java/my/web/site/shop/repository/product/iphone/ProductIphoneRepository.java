package my.web.site.shop.repository.product.iphone;

import my.web.site.shop.model.products.phone.ProductIphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductIphoneRepository extends JpaRepository<ProductIphone, Long> {
    Optional<ProductIphone> findFirstByNameIgnoreCaseAndSize_SizeIgnoreCaseAndColor_ColorIgnoreCase(String name, String size, String color);

    List<ProductIphone> findByNameIgnoreCase(String name);

    List<ProductIphone> findByNameIgnoreCaseAndSize_SizeIgnoreCase(String name, String size);



}
