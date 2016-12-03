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
    public void calculateShouldReturnCorrectResultSum() {
        String input = "/calculator/4.2+6.0";
        Object[] output = new Object[]{"4.2", "+", "6.0"};
        double result = 10.2;
        when(parser.parse(input)).thenReturn(output);
        when(calculator.sum(Double.parseDouble((String) output[0]), Double.parseDouble((String) output[2])))
                .thenReturn(result);
        Assert.assertEquals(result, Double.parseDouble(calculatorService.calculate(input)), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultDiv() {
        String input = "/calculator/4.2/6.0";
        Object[] output = new Object[]{"4.2", "/", "6.0"};
        double result = 0.7;
        when(parser.parse(input)).thenReturn(output);
        when(calculator.div(Double.parseDouble((String) output[0]), Double.parseDouble((String) output[2])))
                .thenReturn(result);
        Assert.assertEquals(result, Double.parseDouble(calculatorService.calculate(input)), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultSub() {
        String input = "/calculator/4.2-6.0";
        Object[] output = new Object[]{"4.2", "-", "6.0"};
        double result = -1.8;
        when(parser.parse(input)).thenReturn(output);
        when(calculator.sub(Double.parseDouble((String) output[0]), Double.parseDouble((String) output[2])))
                .thenReturn(result);
        Assert.assertEquals(result, Double.parseDouble(calculatorService.calculate(input)), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultMult() {
        String input = "/calculator/4.2*6.0";
        Object[] output = new Object[]{"4.2", "*", "6.0"};
        double result = 25.2;
        when(parser.parse(input)).thenReturn(output);
        when(calculator.mult(Double.parseDouble((String) output[0]), Double.parseDouble((String) output[2])))
                .thenReturn(result);
        Assert.assertEquals(result, Double.parseDouble(calculatorService.calculate(input)), DELTA);
    }

    @Test
    public void calculateShouldReturnErrorMessage(){
        String input = "/calculator/4.2jwj*6.0";
        String result = "Invalid input string";
        when(parser.parse(input)).thenReturn(null);
        Assert.assertEquals(result, calculatorService.calculate(input));
    }

}
