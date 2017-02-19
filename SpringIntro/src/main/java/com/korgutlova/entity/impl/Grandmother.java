package com.korgutlova.entity.impl;

import com.korgutlova.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

public class Grandmother implements Human {
    private Transport transport;
    private Attribute attribute;
    private String name;

    @Autowired
    public Grandmother(@Qualifier("newCar") Transport transport, Attribute attribute) {
        this.transport = transport;
        this.attribute = attribute;
    }

    @PostConstruct
    public void someMessage(){
        System.out.println("Bought the car \"" + transport.getName() + "\"");
    }

    @Override
    public void goToPlace(Place place) {
        System.out.println("The motion at a speed of 30 km/h");
        transport.go(place.getAddress());
    }

    @Override
    public void useAttribute() {
        attribute.use();
    }

    @Override
    public void lookExhibit(Exhibit exhibit) {
        exhibit.look();
    }

    @Override
    public void buyTicket() {
        System.out.println("Buying a ticket. Discount 30%");
    }

    @Override
    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setName(String name) {
        this.name = name;
    }
}
