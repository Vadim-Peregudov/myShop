package my.web.site.shop.inerf.user;

import my.web.site.shop.model.user.User;

public interface UserServiceInterface {
    public boolean existUserByLoginAndPassword(User user);

    public User getUserByLoginAndPassword(User user);
}
