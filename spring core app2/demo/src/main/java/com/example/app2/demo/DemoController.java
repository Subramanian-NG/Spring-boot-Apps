package com.example.app2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {

    private VehicleInterface vehicleObj1;
    private VehicleInterface vehicleObj2;

    // injection - it bypass the creation of new CarClass obj. What it does is ->
    // new CarClass() and assign it to DemoController carObj
    // all 3 injections achieve the same

    // field injection - not recommended
    // @Autowired
    // private CarClass carObj;
    // this will autmatically create new object new CarClass() and assign it to
    // DemoController carObj

    // constructor injection - recommended for required dependencies
    // @Autowired
    // public DemoController(CarClass obj) {
    // carObj = obj;
    // }

    // setter injection - recommended for optional dependencies
    // @Autowired
    // public void setVehicle(@Qualifier("car") VehicleInterface obj1,
    // @Qualifier("car") VehicleInterface obj2) {
    // // when you dont specify any class using Qualifier, the primary component(bean) will be used. Qualifier takes priority over Primary
    // // public void setVehicle(VehicleInterface obj) {
    // vehicleObj1 = obj1;
    // vehicleObj2 = obj2;
    // }

    @Autowired
    public void setVehicle(@Qualifier("truckbean") VehicleInterface obj1) {
        // when you dont specify any class using Qualifier, the primary component(bean)
        // will be used. Qualifier takes priority over Primary
        // public void setVehicle(VehicleInterface obj) {
        vehicleObj1 = obj1;
    }

    // @GetMapping("/getType")
    // public String getVehicleType() {
    // System.out.println("Is both injected objects equal - " + (vehicleObj1 ==
    // vehicleObj2));
    // return vehicleObj1.getVehicleType() + " " + vehicleObj2.getVehicleType();

    // }

    @GetMapping("/getType")
    public String getVehicleType() {
        return vehicleObj1.getVehicleType();

    }

}
