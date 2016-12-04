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
    public static void setUp() throws IOException {
        calculatorServlet = new CalculatorServlet();
        httpServletRequest = mock(HttpServletRequest.class);
        httpServletResponse = mock(HttpServletResponse.class);
        PrintWriter printWriter = mock(PrintWriter.class);
        printWriter.println(OUTPUT);
        when(httpServletRequest.getRequestURI()).thenReturn(INPUT);
        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void doGetShouldWorkCorrect() throws ServletException, IOException {
        calculatorServlet.doGet(httpServletRequest, httpServletResponse);
        verify(httpServletRequest).getRequestURI();
        verify(httpServletResponse).getWriter();
    }

    @Test
    public void doPostShouldWorkCorrect() throws ServletException, IOException {

        calculatorServlet.doPost(httpServletRequest, httpServletResponse);
        verify(httpServletResponse).setStatus(405);
    }

}
