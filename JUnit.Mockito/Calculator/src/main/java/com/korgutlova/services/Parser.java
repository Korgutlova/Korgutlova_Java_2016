package com.korgutlova.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser{
    public Object [] parse(String url){
        Pattern pattern = Pattern.compile("/calculator/(?<numberOne>[0-9]+(\\.[0-9]+)?)(?<operator>(\\+|-|\\*|/))" +
                "(?<numberTwo>[0-9]+(\\.[0-9]+)?)");
        Matcher matcher = pattern.matcher(url);
        if(matcher.matches()){
            Object [] data = new Object[3];
            data[0] = matcher.group("numberOne");
            data[1] = matcher.group("operator");
            data[2] = matcher.group("numberTwo");
            return data;
        } else {
            return null;
        }
    }
}
