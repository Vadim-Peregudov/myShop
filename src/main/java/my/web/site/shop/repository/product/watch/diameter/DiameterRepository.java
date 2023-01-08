package my.web.site.shop.repository.product.watch.diameter;

import my.web.site.shop.model.products.watch.diameter.WatchDiameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiameterRepository extends JpaRepository<WatchDiameter,Long> {
}
