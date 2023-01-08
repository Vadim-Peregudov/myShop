package my.web.site.shop.service.user;

import my.web.site.shop.inerf.user.UserServiceInterface;
import my.web.site.shop.model.user.User;
import my.web.site.shop.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceInterfaceImp implements UserServiceInterface {
    @Autowired
    private UserRepository repository;
    @Override
    public boolean existUserByLoginAndPassword(User user) {
        return repository.existsByLoginAndPassword(user.getLogin(),user.getPassword());
    }

    @Override
    public User getUserByLoginAndPassword(User user) {
        return repository.findByLoginAndPassword(user.getLogin(), user.getPassword());
    }
}
