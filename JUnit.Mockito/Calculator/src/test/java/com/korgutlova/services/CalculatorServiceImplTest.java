package com.korgutlova.services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorServiceImplTest {
    private static CalculatorServiceImpl calculatorService;
    private static Calculator calculator;
    private static Parser parser;
    private static final String CORRECT_INPUT = "/calculator/3.1*3.9";
    private static final String INVALID_INPUT = "/calculator/4.2jwj*6.0";
    private static final String DIVIDE_BY_ZERO = "/calculator/3.1/0";
    private static final Object [] CORRECT_ARRAY =  new Object[]{"3.1", "*", "3.9"};
    private static final Object[] DIVIDE_BY_ZERO_ARRAY = new Object[]{"3.1", "/", "0"};
    private static final String RESULT_INVALID_INPUT = "Invalid input string";
    private static final String RESULT_DIVIDE_BY_ZERO = "You can not divide by zero";
    private static final double NUM_1 = 3.1d;
    private static final double NUM_2 = 3.9d;
    private static final double RESULT_SUM = 7.0d;
    private static final double RESULT_DIV = 0.794871d;
    private static final double RESULT_MULT = 12.09d;
    private static final double RESULT_SUB = -0.8d;
    private static final double DELTA = 10e-4;

    @BeforeClass
    public static void setUp() {
        parser = mock(Parser.class);
        calculator = mock(Calculator.class);
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void getResultShouldReturnCorrectResultSum() {
        Assert.assertEquals(RESULT_SUM, Double.parseDouble(calculatorService.getResult(Operator.PLUS, NUM_1, NUM_2)), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultDiv() {
        Assert.assertEquals(RESULT_DIV, Double.parseDouble(calculatorService.getResult(Operator.DIV, NUM_1, NUM_2)), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultSub() {
        Assert.assertEquals(RESULT_SUB, Double.parseDouble(calculatorService.getResult(Operator.MINUS, NUM_1, NUM_2)), DELTA);
    }

    @Test
    public void calculateShouldReturnCorrectResultMult() {
        Assert.assertEquals(RESULT_MULT, Double.parseDouble(calculatorService.getResult(Operator.MULT, NUM_1, NUM_2)), DELTA);
    }

    @Test
    public void calculateShouldReturnErrorMessage(){
        when(parser.parse(INVALID_INPUT)).thenReturn(null);
        Assert.assertEquals(RESULT_INVALID_INPUT, calculatorService.calculate(INVALID_INPUT));
    }

    @Test
    public void calculateShouldReturnResult(){
        when(parser.parse(CORRECT_INPUT)).thenReturn(CORRECT_ARRAY);
        when(calculator.mult(Double.parseDouble((String) CORRECT_ARRAY[0]), Double.parseDouble((String) CORRECT_ARRAY[2])))
                .thenReturn(RESULT_MULT);
        Assert.assertEquals(RESULT_MULT, Double.parseDouble(calculatorService.calculate(CORRECT_INPUT)), DELTA);
    }

    @Test
    public void calculateShouldReturnErrorMessageDivByZero(){
        when(parser.parse(DIVIDE_BY_ZERO)).thenReturn(DIVIDE_BY_ZERO_ARRAY);
        Assert.assertEquals(RESULT_DIVIDE_BY_ZERO, calculatorService.calculate(DIVIDE_BY_ZERO));
    }

}
