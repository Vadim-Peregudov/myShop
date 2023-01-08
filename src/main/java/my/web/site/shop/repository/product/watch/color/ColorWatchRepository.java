package my.web.site.shop.repository.product.watch.color;

import my.web.site.shop.model.products.watch.color.ColorWatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorWatchRepository extends JpaRepository<ColorWatch, Long> {
}
