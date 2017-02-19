package com.korgutlova.config;

import com.korgutlova.entity.*;
import com.korgutlova.entity.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public Place place(){
        Museum museum = new Museum();
        museum.setAddress("street Veronina 17");
        museum.setStatus("closed");
        museum.setName("SPB Museum");
        return museum;
    }

    @Bean
    public Transport transport(){
        Car car = new Car();
        car.setName("Lada");
        return car;
    }

    @Bean
    public Attribute attribute(){
        Glasses glasses = new Glasses();
        glasses.setCost(3000);
        glasses.setDescription("Glasses for farsighted");
        return glasses;
    }

    @Bean
    public Exhibit exhibit(){
        Picture picture = new Picture();
        picture.setGenre("New style");
        picture.setName("Summer");
        return  picture;
    }

    @Bean Human human(){
        Student student = new Student();
        student.setTransport(transport());
        student.setAttribute(attribute());
        student.setName("Misha");
        return student;
    }

}
