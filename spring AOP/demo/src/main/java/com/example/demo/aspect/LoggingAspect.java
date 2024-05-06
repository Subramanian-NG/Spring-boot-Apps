package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    // @Pointcut("execution(void add*())")
    @Pointcut("execution(* com.example.demo.DAO.AppDaoImpl.*(..))")
    private void daoAllMethods() {
    }

    @Pointcut("execution(* com.example.demo.DAO.AppDaoImpl.get*(..))")
    private void daoGetMethods() {
    }

    @Pointcut("execution(* com.example.demo.DAO.AppDaoImpl.set*(..))")
    private void daoSetMethods() {
    }

    // @Before("execution(* com.example.demo.DAO.AppDaoImpl.*(..))")
    // @Before("daoAllMethods() && !(daoGetMethods() || daoSetMethods())")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("before adding account in Logging Aspect");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature--" + methodSignature);

        for (Object object : joinPoint.getArgs()) {
            System.out.println("Method argument--" + object);
        }

    }

    // @Before("daoAllMethods()")
    // public void beforeAddAccount() {
    // System.out.println("before adding account");
    // }

    // @Before("daoPointCutExpression()")
    // public void beforeAddAccount1() {
    // System.out.println("before adding account1");
    // }
}
