package com.korgutlova.services.impl;

import com.korgutlova.dao.MessageDao;
import com.korgutlova.dao.UserDao;
import com.korgutlova.dao.impl.MessageDaoImpl;
import com.korgutlova.dao.impl.UserDaoImpl;
import com.korgutlova.entities.Message;
import com.korgutlova.services.MessageService;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageServiceImpl extends Service implements MessageService {
    private MessageDao messageDao = new MessageDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private Pattern pattern;

    public MessageServiceImpl() {
        pattern = Pattern.compile("(?<text>(\\S| )+) (?<sender>[0-9]+) (?<recipient>[0-9]+) (?<status>(READ|NEW))");
    }

    @Override
    public void createMessage() {
        System.out.println("Enter text, sender id, recipient id, status");
        System.out.println("For example, Hello, guys!!:) 2 45 NEW");
        String inputLine = sc.nextLine();
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.matches()) {
            long senderId = Long.parseLong(matcher.group("sender"));
            long recipientId = Long.parseLong(matcher.group("recipient"));
            if(userDao.existUser(senderId) && userDao.existUser(recipientId)) {
                Message message = new Message(matcher.group("text"), senderId, recipientId,
                        new Timestamp(System.currentTimeMillis()), matcher.group("status"));
                if(messageDao.createMessage(message)){
                    System.out.println("Message created..");
                } else {
                    System.out.println("Failed.. Message isn't created..");
                }
            } else {
                System.out.println("This users aren't exists in database");
            }
        } else {
            System.out.println("Invalid input string. Try again enter another string");
        }
    }
}
