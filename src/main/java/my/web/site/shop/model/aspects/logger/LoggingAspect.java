package my.web.site.shop.model.aspects.logger;

import my.web.site.shop.model.aspects.session.SysContent;
import my.web.site.shop.model.basket.Basket;
import my.web.site.shop.model.basket.BasketCostCalculation;
import my.web.site.shop.model.products.Product;
import my.web.site.shop.model.time.ParsAndGetDateAndTime;
import my.web.site.shop.model.client.Client;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(public String createOrder(..))")
    public Object showInfoUserLogging(ProceedingJoinPoint point) throws Throwable {

        Object targetMethodResult = point.proceed();
        var user = ((Client) Arrays.stream(point.getArgs()).findFirst().filter(e -> e instanceof Client).get());
        if (user.getId() == null) {
            return targetMethodResult;
        }
       Basket basketUser = new Basket(SysContent.getSession());
       showInfoOrder(user,basketUser);

        return targetMethodResult;
    }


    private void showInfoOrder(Client client, Basket basket) {
        System.out.println("-----------------------");
        System.out.println(ParsAndGetDateAndTime.get(client.getDateOrder()));
        System.out.println("Пользователь : " + client.getFullName());
        System.out.println("Контактный номер : " + client.getMobilePhone());
        System.out.println("Email адрес : " + client.getEmail());
        System.out.println("Коментарий к заказу :" + client.getCommentToOrder());
        System.out.println("Корзина :\n" + getInfoBasket(basket));
    }

    private String getInfoBasket(Basket basket) {
        StringBuilder text = new StringBuilder();
        for (Product product : basket.getBasket().keySet()) {
            text.append("\tТовар : ").append(product).append(", в количестве").append(basket.getBasket().get(product)).
                    append("\n");
        }
        text.append("\t\t").append("Сумма заказа составляет : ").append(BasketCostCalculation.calcBasket(basket)).append("руб.");
        return text.toString();
    }


}
