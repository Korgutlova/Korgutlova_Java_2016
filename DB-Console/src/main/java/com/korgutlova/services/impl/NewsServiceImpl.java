package com.korgutlova.services.impl;

import com.korgutlova.dao.CommunityDao;
import com.korgutlova.dao.NewsDao;
import com.korgutlova.dao.UserDao;
import com.korgutlova.dao.impl.CommunityDaoImpl;
import com.korgutlova.dao.impl.NewsDaoImpl;
import com.korgutlova.dao.impl.UserDaoImpl;
import com.korgutlova.entities.News;
import com.korgutlova.services.NewsService;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsServiceImpl extends Service implements NewsService {
    private NewsDao newsDao = new NewsDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private CommunityDao communityDao = new CommunityDaoImpl();
    private Pattern text = Pattern.compile("text (?<text>(\\S| )+)");
    private Pattern communityId = Pattern.compile("community_id (?<community>[0-9]+)");
    private Pattern authorId = Pattern.compile("author_id (?<author>[0-9]+)");
    private Pattern createdAt = Pattern.compile("created_at (?<created>(2|1)[0-9]{3}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01]) " +
            "([0-1]\\d|2[0-3])(:[0-5]\\d){2})");

    @Override
    public void updateNews() {
        System.out.println("Enter id news");
        long id;
        News news;
        while ((news = newsDao.getNews(id = Long.parseLong(sc.nextLine()))) == null) {
            System.out.println("News not found. Enter another id");
        }
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the field you want to change (For example, text Cool news!, community_id 1, " +
                    "author_id 23, created_at 2012-11-31 12:34:59) or \"OK\" to apply the edit.");
            String inputLine = sc.nextLine();
            Matcher matcher;
            if ((matcher = text.matcher(inputLine)).matches()) {
                news.setText(matcher.group("text"));
            } else if ((matcher = communityId.matcher(inputLine)).matches()) {
                long communityId = Long.parseLong(matcher.group("community"));
                if (communityDao.getCommunity(communityId) != null) {
                    news.setCommunityId(communityId);
                } else {
                    System.out.println("Community is not found");
                }
            } else if ((matcher = authorId.matcher(inputLine)).matches()) {
                long authorId = Long.parseLong(matcher.group("author"));
                if (userDao.existUser(authorId)) {
                    news.setAuthorId(authorId);
                } else {
                    System.out.println("User is not found");
                }
            } else if ((matcher = createdAt.matcher(inputLine)).matches()) {
                news.setCreatedAt(Timestamp.valueOf(matcher.group("created")));
            } else if (inputLine.equals("OK")) {
                System.out.println("The use of editing");
                flag = false;
            } else {
                System.out.println("Invalid input string. Try again enter another string");
            }

        }
        if (newsDao.updateNews(news)) {
            System.out.println("News " + id + " edited");
        } else {
            System.out.println("Failed to edit news");
        }
    }
}
