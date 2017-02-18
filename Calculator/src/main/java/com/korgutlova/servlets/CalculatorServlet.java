package com.korgutlova.servlets;

import com.korgutlova.helpers.HelperRender;
import com.korgutlova.services.CalculatorService;
import com.korgutlova.services.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CalculatorServlet extends HttpServlet {
    private CalculatorService calculatorService = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oneArg = request.getParameter("oneArg");
        String twoArg = request.getParameter("twoArg");
        String operation = request.getParameter("operation");
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", oneArg != null && twoArg != null ? calculatorService.calculate(oneArg, twoArg, operation) : "");
        HelperRender.render(request, response, "calculator.ftl", map);
    }
}
