package com.korgutlova.services;

public class CalculatorServiceImpl implements CalculatorService, Operator {
    private static Parser parser = new Parser();
    private static Calculator calculator = new Calculator();

    @Override
    public String calculate(String url) {
        Object[] data = parser.parse(url);
        if (data != null) {
            double firstNumber = Double.parseDouble((String) data[0]);
            char operator = ((String) data[1]).charAt(0);
            double secondNumber = Double.parseDouble((String) data[2]);
            if (operator == DIV && secondNumber == 0) {
                return "You can not divide by zero";
            } else {
                double result = getResult(operator, firstNumber, secondNumber);
                return String.valueOf(result);
            }
        } else {
            return "Invalid input string";
        }
    }

    public double getResult(char operator, double firstNumber, double secondNumber) {
        switch (operator) {
            case MINUS:
                return calculator.sub(firstNumber, secondNumber);
            case PLUS:
                return calculator.sum(firstNumber, secondNumber);
            case DIV:
                return calculator.div(firstNumber, secondNumber);
            case MULT:
                return calculator.mult(firstNumber, secondNumber);
            default:
                return 0;
        }
    }
}
