package com.security.valid;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Chris on 2018/4/9.
 */
public class MyNotNullImpl implements ConstraintValidator<MyNotNull,Object> {
    @Override
    public void initialize(MyNotNull constraintAnnotation) {
        System.out.println("my not null chu shi hua ");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return StringUtils.isNotBlank(value.toString());
    }
}
