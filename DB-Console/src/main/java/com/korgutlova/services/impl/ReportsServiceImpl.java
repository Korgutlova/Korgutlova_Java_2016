package com.korgutlova.services.impl;

import com.korgutlova.dao.ReportsDao;
import com.korgutlova.dao.UserDao;
import com.korgutlova.dao.impl.ReportsDaoImpl;
import com.korgutlova.dao.impl.UserDaoImpl;
import com.korgutlova.entities.User;
import com.korgutlova.services.ReportsService;

import java.util.List;

public class ReportsServiceImpl extends Service implements ReportsService {
    private ReportsDao reportsDao = new ReportsDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void getReports() {
        System.out.println("Select the required report, enter the number: ");
        System.out.println("(1) The total number of news in all communities, based some user");
        System.out.println("(2) Users who receive the most messages for any season");
        System.out.println("(3) Customers responded to the greatest number of requests " +
                "that have been submitted to the address that contains any character set");
        int inputNumber = Integer.parseInt(sc.nextLine());
        try {
            switch (inputNumber) {
                case 1: {
                    System.out.println("Enter user id");
                    long id = Long.parseLong(sc.nextLine());
                    if (userDao.existUser(id)) {
                        long countNews = reportsDao.getNewsInCommunity(id);
                        System.out.println(countNews);
                    } else {
                        System.out.println("User is not found");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter season");
                    int[] months = new int[3];
                    Season season = Season.valueOf(sc.nextLine().toUpperCase());
                    switch (season) {
                        case WINTER:
                            months = new int[]{12, 1, 2};
                            break;
                        case SPRING:
                            months = new int[]{3, 4, 5};
                            break;
                        case SUMMER:
                            months = new int[]{6, 7, 8};
                            break;
                        case AUTUMN:
                            months = new int[]{9, 10, 11};
                            break;
                        default:
                            System.out.println("Incorrect Season");
                            break;
                    }
                    List<User> users = reportsDao.getUsersWithTheMostMessages(months);
                    users.forEach(System.out::println);
                    break;
                }
                case 3: {
                    System.out.println("Enter the character set contained in the address");
                    List<User> users = reportsDao.getRespondedUsersWithTheMostRequests(sc.nextLine());
                    users.forEach(System.out::println);
                    break;
                }
                default:
                    System.out.println("Incorrect number");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Type mismatch!");
        }
    }
}
