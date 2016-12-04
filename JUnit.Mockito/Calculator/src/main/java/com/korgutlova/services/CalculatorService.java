package com.korgutlova.services;

public interface CalculatorService {
    String calculate(String url);

    double getResult(char operator, double firstNumber, double secondNumber);
}
