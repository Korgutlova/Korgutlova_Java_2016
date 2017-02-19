package com.korgutlova.entity.impl;

import com.korgutlova.entity.Exhibit;
import org.springframework.beans.factory.FactoryBean;

public class PictureFactory implements FactoryBean<Exhibit> {
    private String name;

    @Override
    public Exhibit getObject() throws Exception {
        Exhibit exhibit = new Picture();
        exhibit.setGenre("Suprematism");
        exhibit.setName(name);
        return exhibit;
    }

    @Override
    public Class<?> getObjectType() {
        return Exhibit.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }
}
