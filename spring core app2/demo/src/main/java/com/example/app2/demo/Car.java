package com.example.app2.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//@Component - if you specify component, it is a bean
@Component
// when you change scope to prototype, for each injection, new instance will be
// created. default is singleton(only one instance)
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Car implements VehicleInterface {

    private String vehicleType = "Car";

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @PostConstruct
    public void initOnBeanInitialize() {
        System.out.println("initOnBeanInitialize");
    }

    @PreDestroy
    public void exitOnBeanDestroy() {
        System.out.println("exitOnBeanDestroy");
    }
}
