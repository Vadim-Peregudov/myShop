package my.web.site.shop.model.aspects.security;

import my.web.site.shop.inerf.user.UserServiceInterface;
import my.web.site.shop.model.aspects.session.SysContent;
import my.web.site.shop.model.user.roles.Roles;
import my.web.site.shop.model.user.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspect {
    @Autowired
    private UserServiceInterface serviceUser;

  //  @Around("execution(public String admin*(..))")
  //  public Object checkingUserRights(ProceedingJoinPoint point) throws Throwable {
  //      Object targetMethodResult = point.proceed();
  //      User user = (User) SysContent.getSession().getAttribute("user");
//
  //      targetMethodResult = checkUser(user, targetMethodResult);
//
  //      return targetMethodResult;
  //  }

    private Object checkUser(User user, Object targetMethodResult) {
        if (user == null) {
            return "redirect:/admin/auth";
        }
        if (serviceUser.existUserByLoginAndPassword(user)) {
            SysContent.getSession().setAttribute("user", serviceUser.getUserByLoginAndPassword(user));
            user = (User) SysContent.getSession().getAttribute("user");
        } else {
            return "redirect:/admin/auth";
        }
        if (!user.getRole().getRoll().equalsIgnoreCase(Roles.ADMIN.getRoll())) {
            return "redirect:/admin/auth";
        }
        return targetMethodResult;
    }


}
