package com.korgutlova.controller;

import com.korgutlova.entity.ModelHuman;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    List<ModelHuman> modelList;

    public IndexController() {
        modelList = new ArrayList<>();
    }

    @RequestMapping(name = "/index", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(name = "/table", method = RequestMethod.POST)
    public String getTablePage(@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName,
                               @RequestParam(value = "middleName") String middleName, @RequestParam(value = "gender") String gender,
                               @RequestParam(value = "date") String date, Model model) {
        ModelHuman human = null;
        try {
            human = new ModelHuman(name, lastName, middleName, gender, getDate(date));
        } catch (ParseException e) {
            System.out.println("Some problems with date");
        }
        modelList.add(human);
        model.addAttribute("list", modelList);
        return "table";
    }

    private Date getDate(String date) throws ParseException {
        if (date.equals("")) {
            return null;
        }
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }
}
