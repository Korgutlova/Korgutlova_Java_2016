package com.korgutlova;

import com.korgutlova.config.JavaConfig;
import com.korgutlova.entity.Human;
import com.korgutlova.entity.Place;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Place place = context.getBean(Place.class);
        Human human = context.getBean(Human.class);
        human.useAttribute();
        human.goToPlace(place);
        System.out.println(place.getAddress());
    }
}
