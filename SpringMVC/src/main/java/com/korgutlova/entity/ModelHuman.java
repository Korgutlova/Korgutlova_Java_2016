package com.korgutlova.entity;

import java.util.Date;

public class ModelHuman {
    private String name;
    private String lastName;
    private String middleName;
    private String gender;
    private Date date;

    public ModelHuman(String name, String lastName, String middleName, String gender, Date date) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date != null ? date.toLocaleString().substring(0, 11) : "";
    }
}
