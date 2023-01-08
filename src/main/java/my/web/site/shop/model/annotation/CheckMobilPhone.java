package my.web.site.shop.model.annotation;


import my.web.site.shop.model.annotation.validator.CheckMobilPhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckMobilPhoneValidator.class)
public @interface CheckMobilPhone {
    String regexp() default ".*";

    String message() default "Mobile phone is not correct";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
