package com.security.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Chris on 2018/4/9.
 */
// zhi ding zhujie weizhi
@Target({ElementType.FIELD, ElementType.METHOD})
// zhi ding shengxiao de zhouqi
@Retention(RetentionPolicy.RUNTIME)
// zhiding luoji lei
@Constraint(validatedBy = MyNotNullImpl.class)
public @interface MyNotNull {
    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
