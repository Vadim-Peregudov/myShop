package my.web.site.shop.repository.client;

import my.web.site.shop.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    boolean existsByFullNameAndMobilePhoneAndEmailAndCommentToOrder(String fullName, String mobilePhone, String email, String commentToOrder);

    List<Client> findByFullNameAndMobilePhoneAndEmail(String fullName, String mobilePhone, String email);

}
