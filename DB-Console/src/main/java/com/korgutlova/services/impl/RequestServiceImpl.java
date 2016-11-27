package com.korgutlova.services.impl;

import com.korgutlova.dao.RequestDao;
import com.korgutlova.dao.UserDao;
import com.korgutlova.dao.impl.RequestDaoImpl;
import com.korgutlova.dao.impl.UserDaoImpl;
import com.korgutlova.entities.Request;
import com.korgutlova.services.RequestService;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestServiceImpl extends Service implements RequestService {
    private RequestDao requestDao = new RequestDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private Pattern pattern;

    public RequestServiceImpl() {
        pattern = Pattern.compile("(?<needy>[0-9]+) (?<volunteer>([0-9]+|<null>)) " +
                "(?<address>([0-9a-zA-Z_-]| ){1,50}) (?<latitude>-?[0-9]{1,3}(\\.[0-9]{1,5})?) " +
                "(?<longitude>-?[0-9]{1,3}(\\.[0-9]{1,5})?) (?<service>([0-9a-zA-Z_-]| ){1,20}) (?<status>(ACTIVE|RENDING|CLOSED))");
    }

    @Override
    public void createRequest() {
        System.out.println("Enter needy id, volunteer id, address, latitude and longitude, " +
                "service, status(ACTIVE, RENDING, CLOSED)");
        System.out.println("For example, 23 987(or <null>) 8722 Spohn Junction 56.89 -4.213  MARKET ACTIVE");
        String inputLine = sc.nextLine();
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.matches()) {
            long needyId = Long.parseLong(matcher.group("needy"));
            if (userDao.existUser(needyId)) {
                long volunteerId = !matcher.group("volunteer").equals("<null>") ? Long.parseLong(matcher.group("volunteer")) : 0;
                if((volunteerId != 0 && userDao.existUser(volunteerId)) || volunteerId == 0) {
                    double latitude = Double.parseDouble(matcher.group("latitude"));
                    double longitude = Double.parseDouble(matcher.group("longitude"));
                    String address = matcher.group("address");
                    String service = matcher.group("service");
                    String status = matcher.group("status");
                    Request request = new Request(needyId, volunteerId, address, latitude, longitude,
                            new Timestamp(System.currentTimeMillis()), service, status);
                    if (requestDao.createRequest(request)){
                        System.out.println("Request created..");
                    } else {
                        System.out.println("Failed.. Request isn't created..");
                    }
                }
            } else {
                System.out.println("Needy id " + needyId + "isn't exists in database.");
            }
        } else {
            System.out.println("Invalid input string. Try again enter another string");
        }
    }
}
