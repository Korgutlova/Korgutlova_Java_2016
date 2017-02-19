package com.korgutlova;

import com.korgutlova.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXmlConfig {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Place place = context.getBean(Place.class);
        Exhibit exhibit = context.getBean("malevich", Exhibit.class);
        Exhibit newExhibit = context.getBean("rozanova", Exhibit.class);
        Human human = context.getBean("student", Human.class);
        Human newHuman = context.getBean("newStudent", Human.class);
        newHuman.setTransport(context.getBean("car", Transport.class));
        newHuman.goToPlace(place);
        human.useAttribute();
        human.goToPlace(place);
        human.buyTicket();
        human.lookExhibit(exhibit);
        human.lookExhibit(newExhibit);
        Human grandmother = context.getBean("grandmother", Human.class);
        grandmother.goToPlace(place);
        grandmother.useAttribute();
    }
}
