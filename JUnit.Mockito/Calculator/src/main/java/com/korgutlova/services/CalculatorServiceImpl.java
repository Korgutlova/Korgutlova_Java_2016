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
            return getResult(operator, firstNumber, secondNumber);

        } else {
            return "Invalid input string";
        }
    }

    protected String getResult(char operator, double firstNumber, double secondNumber) {
        switch (operator) {
            case MINUS:
                return String.valueOf(calculator.sub(firstNumber, secondNumber));
            case PLUS:
                return String.valueOf(calculator.sum(firstNumber, secondNumber));
            case DIV:
                try {
                    return String.valueOf(calculator.div(firstNumber, secondNumber));
                } catch (ArithmeticException e){
                    return "You can not divide by zero";
                }
            case MULT:
                return String.valueOf(calculator.mult(firstNumber, secondNumber));
            default:
                return "Something error";
        }
    }
}
