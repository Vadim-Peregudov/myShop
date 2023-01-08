package my.web.site.shop.repository.user;

import my.web.site.shop.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginAndPassword(String login, String password);
    User findByLoginAndPassword(String login, String password);



}
