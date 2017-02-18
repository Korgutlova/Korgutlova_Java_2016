package com.korgutlova.entity.impl;

import com.korgutlova.entity.*;

public class Student implements Human {
    private String name;
    private Transport transport;
    private Attribute attribute;

    @Override
    public void goToPlace(Place place) {
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
        System.out.println("Buying a ticket. Discount 15%");
    }

    @Override
    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
