package com.example.app2.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app2.demo.Truck;
import com.example.app2.demo.VehicleInterface;

@Configuration
public class TruckConfig {
    @Bean("truckbean")
    public Truck truckObj() {
        return new Truck();
    }

}
