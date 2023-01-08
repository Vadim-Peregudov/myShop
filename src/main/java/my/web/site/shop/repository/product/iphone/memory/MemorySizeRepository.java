package my.web.site.shop.repository.product.iphone.memory;

import my.web.site.shop.model.products.phone.memory.MemorySizeIphone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemorySizeRepository extends JpaRepository<MemorySizeIphone, Long> {
    Optional<MemorySizeIphone> findBySizeIgnoreCase(String size);

}
