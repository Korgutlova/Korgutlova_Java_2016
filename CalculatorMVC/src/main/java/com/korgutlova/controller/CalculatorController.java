package com.korgutlova.controller;

import com.korgutlova.services.CalculatorService;
import com.korgutlova.services.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService = new ServiceImpl();

    @RequestMapping(name = "/result", method = RequestMethod.POST)
    public String getResultPage(@RequestParam(name = "oneArg") String oneArg, @RequestParam(name = "twoArg") String twoArg,
                                    @RequestParam(name = "operation") String operation, Model model) {
        model.addAttribute("result", oneArg != null && twoArg != null ? calculatorService.calculate(oneArg, twoArg, operation) : "");
        return "index";
    }

    @RequestMapping(name = "/calculator", method = RequestMethod.GET)
    public String getCalculatorPage() {
        return "index";
    }
}
