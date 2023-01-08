package my.web.site.shop.repository.product.watch;

import my.web.site.shop.model.products.watch.ProductWatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductWatchRepository extends JpaRepository<ProductWatch, Long> {
    List<ProductWatch> findByNameIgnoreCase(String name);

}
