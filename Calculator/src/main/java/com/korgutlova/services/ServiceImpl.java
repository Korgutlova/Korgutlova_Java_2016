package com.korgutlova.services;

import java.util.regex.Pattern;

public class ServiceImpl implements CalculatorService {
    private Calculator calculator = new Calculator();

    @Override
    public String calculate(String a, String b, String operation) {
        if (checkNumber(a) && checkNumber(b)) {
            double firstNumber = Double.parseDouble(a);
            double secondNumber = Double.parseDouble(b);
            Operator operator = Operator.valueOf(operation);
            return getResult(firstNumber, secondNumber, operator);
        } else {
            return "Invalid input numbers!";
        }
    }

    private String getResult(double firstNumber, double secondNumber, Operator operator) {
        switch (operator) {
            case SUB:
                return String.valueOf(calculator.sub(firstNumber, secondNumber));
            case SUM:
                return String.valueOf(calculator.sum(firstNumber, secondNumber));
            case DIV:
                try {
                    return String.valueOf(calculator.div(firstNumber, secondNumber));
                } catch (ArithmeticException e) {
                    return "You can not divide by zero";
                }
            case MULT:
                return String.valueOf(calculator.mult(firstNumber, secondNumber));
            default:
                return "Something error";
        }
    }

    private boolean checkNumber(String a) {
        return Pattern.compile("(-)?[0-9]+(\\.[0-9]+)?").matcher(a).matches();
    }
}
