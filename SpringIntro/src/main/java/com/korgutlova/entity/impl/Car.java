package com.korgutlova.entity.impl;

import com.korgutlova.entity.Transport;
import org.springframework.stereotype.Component;

@Component
public class Car implements Transport{
    private String name;

    @Override
    public void go(String place) {
        System.out.println("We go by car \"" + name + "\" to the address: " + place);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
