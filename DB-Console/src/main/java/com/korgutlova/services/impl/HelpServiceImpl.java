package com.korgutlova.services.impl;

import com.korgutlova.services.HelpService;

import java.util.ArrayList;

public class HelpServiceImpl extends Service implements HelpService{
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void showCommand() {
        for(String command: list){
            System.out.println(command);
        }
    }

    @Override
    public void init() {
        list.add("add new user");
        list.add("add new message");
        list.add("add new request");
        list.add("edit news");
        list.add("edit community");
        list.add("get reports");
        list.add("-help");
        list.add("exit");
    }
}
