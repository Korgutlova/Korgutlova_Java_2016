package com.korgutlova.entity.impl;

import com.korgutlova.entity.Place;

public class Museum implements Place {

    private String name;
    private String status;
    private String address;

    public String getStatus() {
        return status;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
