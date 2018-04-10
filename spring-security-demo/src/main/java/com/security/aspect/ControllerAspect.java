package com.security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Chris on 2018/4/11.
 */
@Aspect
@Component
public class ControllerAspect {

    @Around("execution( * com.security.controller.UserController.* (..))")
    public Object timer(ProceedingJoinPoint pd) throws Throwable {
        System.out.println("aspect ........................");
        Long start = new Date().getTime();
        Object[] args = pd.getArgs();
        Arrays.stream(args).forEach(arg -> System.out.println(arg));
        Object proceed = pd.proceed();
        System.out.println("total time:" + (new Date().getTime() - start));
        return proceed;
    }
}
