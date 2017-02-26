package com.korgutlova.controller;

import com.korgutlova.model.enums.Subject;
import com.korgutlova.services.JdbcTemplateDao;
import com.korgutlova.services.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private final ScoresService scoresService;

    @Autowired
    public MainController(JdbcTemplateDao scoresService) {
        this.scoresService = scoresService;
    }

    @RequestMapping("/totalscore")
    @ResponseBody
    public String getTotalScore(@RequestParam(name = "id") String id) {
        return "Total score: " + String.valueOf(scoresService.getTotalScore(Long.valueOf(id)));
    }

    @RequestMapping("/avgscore")
    @ResponseBody
    public String getAvgScore(@RequestParam(name = "id") String id) {
        return "Average score: " + String.valueOf(scoresService.getAverageScore(Long.valueOf(id)));
    }

    @RequestMapping("/score")
    @ResponseBody
    public String getScore(@RequestParam(name = "id") String id, @RequestParam(name = "subject") String subject) {
        return "Score for " + subject + ": " +
                String.valueOf(scoresService.getScoreOnTheSubject(Long.valueOf(id), Subject.valueOf(subject.toUpperCase())));
    }
}
