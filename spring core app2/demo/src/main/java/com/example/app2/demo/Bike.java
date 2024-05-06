package com.example.app2.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component - if you specify component, it is a bean
//bean is a spring object created and maintained by spring container. You dont have to create a new object. The spring has control over it. This is called inversion of control. By using an annotation, you can use that object.
@Component
// @Primary
public class Bike implements VehicleInterface {

    private String type = "bike";

    @Override
    public String getVehicleType() {
        return type;
    }

}
