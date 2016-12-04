package com.korgutlova.services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorServiceImplTest {
    private static CalculatorService calculatorService;
    private static Calculator calculator;
    private static Parser parser;
    private static final double DELTA = 10e-4;

    @BeforeClass
    public static void setUp() {
        parser = mock(Parser.class);
        calculator = mock(Calculator.class);
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void getResultShouldReturnCorrectResultSum() {
        Assert.assertEquals(7.0, calculatorService.getResult('+', 3.1d, 3.9d), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultDiv() {
        Assert.assertEquals(0.794871, calculatorService.getResult('/', 3.1d, 3.9d), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultSub() {
        Assert.assertEquals(-0.8d, calculatorService.getResult('-', 3.1d, 3.9d), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultMult() {
        Assert.assertEquals(12.09d, calculatorService.getResult('*', 3.1d, 3.9d), DELTA);
    }

    @Test
    public void calculateShouldReturnErrorMessage(){
        String input = "/calculator/4.2jwj*6.0";
        String result = "Invalid input string";
        when(parser.parse(input)).thenReturn(null);
        Assert.assertEquals(result, calculatorService.calculate(input));
    }

    @Test
    public void calculateShouldReturnResult(){
        String input = "/calculator/4.2*6.0";
        Object[] output = new Object[]{"4.2", "*", "6.0"};
        double result = 25.2;
        when(parser.parse(input)).thenReturn(output);
        when(calculator.mult(Double.parseDouble((String) output[0]), Double.parseDouble((String) output[2])))
                .thenReturn(result);
        Assert.assertEquals(result, Double.parseDouble(calculatorService.calculate(input)), DELTA);
    }

    @Test
    public void calculateShouldReturnErrorMessageDivByZero(){
        String input = "/calculator/4.2/0";
        Object[] output = new Object[]{"4.2", "/", "0"};
        String result = "You can not divide by zero";
        when(parser.parse(input)).thenReturn(output);
        Assert.assertEquals(result, calculatorService.calculate(input));
    }

}
