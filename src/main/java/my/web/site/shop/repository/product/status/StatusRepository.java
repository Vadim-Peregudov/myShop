package my.web.site.shop.repository.product.status;

import my.web.site.shop.model.products.status.StatusProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusProduct,Long> {
}
