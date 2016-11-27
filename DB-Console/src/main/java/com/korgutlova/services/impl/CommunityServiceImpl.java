package com.korgutlova.services.impl;

import com.korgutlova.dao.CommunityDao;
import com.korgutlova.dao.UserDao;
import com.korgutlova.dao.impl.CommunityDaoImpl;
import com.korgutlova.dao.impl.UserDaoImpl;
import com.korgutlova.entities.Community;
import com.korgutlova.services.CommunityService;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommunityServiceImpl extends Service implements CommunityService {
    private CommunityDao communityDao = new CommunityDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private Pattern name = Pattern.compile("name (?<name>[a-zA-Z]{3,20})");
    private Pattern description = Pattern.compile("description (?<description>(\\S| )+)");
    private Pattern founderId = Pattern.compile("founder_id (?<founder>[0-9]+)");
    private Pattern createdAt = Pattern.compile("created_at (?<created>(2|1)[0-9]{3}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01]))");

    @Override
    public void updateCommunity() {
        System.out.println("Enter id community");
        long id;
        Community community;
        while ((community = communityDao.getCommunity(id = Long.parseLong(sc.nextLine()))) == null) {
            System.out.println("Community not found. Enter another id");
        }
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the field you want to change (For example, name Example, description Cool article, " +
                    "founder_id 23, created_at 2012-11-31) or \"OK\" to apply the edit.");
            String inputLine = sc.nextLine();
            Matcher matcher;
            if ((matcher = name.matcher(inputLine)).matches()) {
                community.setName(matcher.group("name"));
            } else if ((matcher = description.matcher(inputLine)).matches()) {
                community.setDescription(matcher.group("description"));
            } else if ((matcher = founderId.matcher(inputLine)).matches()) {
                long founderId = Long.parseLong(matcher.group("founder"));
                if (userDao.existUser(founderId)) {
                    community.setFounderId(founderId);
                } else {
                    System.out.println("User is not found");
                }
            } else if ((matcher = createdAt.matcher(inputLine)).matches()) {
                community.setCreatedAt(Date.valueOf(matcher.group("created")));
            } else if (inputLine.equals("OK")) {
                System.out.println("The use of editing");
                flag = false;
            } else {
                System.out.println("Invalid input string. Try again enter another string");
            }
        }
        if (communityDao.updateCommunity(community)) {
            System.out.println("Community " + id + " edited");
        } else {
            System.out.println("Failed to edit community");
        }
    }
}
