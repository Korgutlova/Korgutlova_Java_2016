package com.korgutlova.services.impl;

import com.korgutlova.dao.UserDao;
import com.korgutlova.dao.impl.UserDaoImpl;
import com.korgutlova.entities.User;
import com.korgutlova.services.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl extends Service implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private Pattern name = Pattern.compile("(?<name>[a-zA-Z]{3,50})");
    private Pattern surname = Pattern.compile("(?<surname>[a-zA-Z]{3,50})");
    private Pattern mail = Pattern.compile("(?<mail>[a-zA-Z_]{1}[a-zA-Z_0-9]*@[a-zA-Z]+\\.[a-zA-Z]+)");
    private Pattern password = Pattern.compile("(?<password>[a-zA-Z0-9]{6,225})");
    private Pattern pattern;

    public UserServiceImpl(){
        pattern = Pattern.compile(name + " " + surname + " " + mail + " " + password + " (?<role>ROLE_(USER|ADMIN))" +
                " (?<status>(ACTIVE|BANNED))");
    }
    public void createUser() {
        System.out.println("Enter name, surname, email, password, role, status");
        System.out.println("For example, Masha Ivanova masha123@mail.ru 1234masha ROLE_USER ACTIVE");
        String inputLine = sc.nextLine();
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.matches()){
            User user = new User(matcher.group("name"), matcher.group("surname"), matcher.group("mail"),
                    matcher.group("password"), matcher.group("role"), matcher.group("status"));
            if(userDao.createUser(user)){
                System.out.println("User created..");
            } else {
                System.out.println("Failed.. User isn't created..");
            }
        } else {
            System.out.println("Invalid input string. Try again enter another string");
        }

    }
}
