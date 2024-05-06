package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class SecurityAspect {

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
    public void beforeAdvice() {
        System.out.println("before adding account in Security Aspect");
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.DAO.AppDaoImpl.getData(..))", returning = "result")
    public void afterAdvice(JoinPoint joinPoint, String result) {
        System.out.println("after returning account in Security Aspect");
        System.out.println("result string---" + result);
    }

    @Around("execution(* com.example.demo.DAO.AppDaoImpl.getInfo(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("before calling getInfo in Security Aspect");
        Object result;
        try {
            // result = joinPoint.proceed();
            // System.out.println("result string after getInfo---" + result);
        } catch (Throwable e) {
            e.printStackTrace();
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
