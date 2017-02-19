package com.korgutlova.entity.impl;

import com.korgutlova.entity.Exhibit;

public class Picture implements Exhibit{
    private String name;
    private String genre;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void look() {
        System.out.println("He looks a picture \"" + name + "\" for 5 minutes");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
