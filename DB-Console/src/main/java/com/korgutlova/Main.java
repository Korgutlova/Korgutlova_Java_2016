package com.korgutlova;

import com.korgutlova.services.*;
import com.korgutlova.services.impl.*;

import java.util.Scanner;

public class Main {
    private static UserService userService = new UserServiceImpl();
    private static MessageService messageService = new MessageServiceImpl();
    private static RequestService requestService = new RequestServiceImpl();
    private static NewsService newsService = new NewsServiceImpl();
    private static CommunityService communityService = new CommunityServiceImpl();
    private static ReportsService reportsService = new ReportsServiceImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        HelpService helpService = new HelpServiceImpl();
        helpService.init();
        System.out.println("Welcome to the console program, to work with the database");
        System.out.println("If you need help, call the command \"-help\"");
        System.out.print("> ");
        while (!(line = sc.nextLine()).equals("exit")) {
            switch (line) {
                case "add new user":
                    userService.createUser();
                    break;
                case "add new message":
                    messageService.createMessage();
                    break;
                case "add new request":
                    requestService.createRequest();
                    break;
                case "edit news":
                    newsService.updateNews();
                    break;
                case "edit community":
                    communityService.updateCommunity();
                    break;
                case "get reports":
                    reportsService.getReports();
                    break;
                case "-help":
                    System.out.println("You can use the following commands:");
                    helpService.showCommand();
                    break;
                default:
                    System.out.println("Invalid command. Enter command again or write \"-help\"");
                    break;
            }
            System.out.print("> ");
        }
    }
}
