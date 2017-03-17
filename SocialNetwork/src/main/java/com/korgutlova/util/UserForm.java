package com.korgutlova.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class UserForm {

    private static final String BLANK_MESSAGE = "This field is mandatory";

    @NotBlank(message = BLANK_MESSAGE)
    @Email
    private String email;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(min = 7, max = 20, message = "Password should be from 7 to 20 symbols")
    private String password;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(max = 50, message = "Oops, less than 50 symbols")
    private String name;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(max = 50, message = "Oops, less than 50 symbols")
    private String surname;

    @Size(max = 500, message = "Oops, less than 500 symbols")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSurname() {
        return surname;

    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
