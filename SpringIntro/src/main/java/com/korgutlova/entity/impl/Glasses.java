package com.korgutlova.entity.impl;

import com.korgutlova.entity.Attribute;
import org.springframework.stereotype.Component;

@Component
public class Glasses implements Attribute{

    private String description;
    private double cost;

    @Override
    public void use() {
        System.out.println("Human wears glasses. Now he sees better");
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
