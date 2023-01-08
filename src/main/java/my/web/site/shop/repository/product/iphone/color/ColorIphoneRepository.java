package my.web.site.shop.repository.product.iphone.color;

import my.web.site.shop.model.products.phone.color.ColorIphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorIphoneRepository extends JpaRepository<ColorIphone, Long> {
    Optional<ColorIphone> findByColorIgnoreCase(String color);

}
