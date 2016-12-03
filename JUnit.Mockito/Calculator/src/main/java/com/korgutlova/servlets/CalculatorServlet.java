package com.korgutlova.servlets;

import com.korgutlova.services.CalculatorService;
import com.korgutlova.services.CalculatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {
    private CalculatorService calculatorService = new CalculatorServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(405);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = calculatorService.calculate(request.getRequestURI());
        response.getWriter().println(result);
    }
}
