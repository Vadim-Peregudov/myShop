package my.web.site.shop.model.annotation.validator;

import my.web.site.shop.model.annotation.CheckMobilPhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMobilPhoneValidator implements ConstraintValidator<CheckMobilPhone, String> {
    private String patternMobilPhone;
    @Override
    public void initialize(CheckMobilPhone constraintAnnotation) {
        patternMobilPhone = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String mobilPhone, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(patternMobilPhone);
        Matcher matcher = pattern.matcher(mobilPhone);
        return matcher.matches();
    }
}
