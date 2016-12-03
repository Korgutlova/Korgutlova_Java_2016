package com.korgutlova.servlets;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class CalculatorServletTest {
    private static CalculatorServlet calculatorServlet;
    private static HttpServletResponse httpServletResponse;
    private static HttpServletRequest httpServletRequest;
    private static final String INPUT = "/calculator/4+3.5";
    private static final String OUTPUT = "7.5";

    @BeforeClass
    public static void setUp() {
        calculatorServlet = new CalculatorServlet();
        httpServletRequest = mock(HttpServletRequest.class);
        httpServletResponse = mock(HttpServletResponse.class);
        PrintWriter printWriter = mock(PrintWriter.class);
        when(httpServletRequest.getRequestURI()).thenReturn(INPUT);
        try {
            when(httpServletResponse.getWriter()).thenReturn(printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doGetShouldWorkCorrect() throws ServletException, IOException {
        calculatorServlet.doGet(httpServletRequest, httpServletResponse);
        verify(httpServletRequest).getRequestURI();
    }

    @Test
    public void doPostShouldWorkCorrect() throws ServletException, IOException {

        calculatorServlet.doPost(httpServletRequest, httpServletResponse);
        verify(httpServletResponse).setStatus(405);
    }

}
