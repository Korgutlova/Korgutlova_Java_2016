package com.korgutlova.services;

public class CalculatorServiceImpl implements CalculatorService, Operator {
    private static Parser parser = new Parser();
    private static Calculator calculator = new Calculator();

    @Override
    public String calculate(String url) {
        Object [] data = parser.parse(url);
        if(data != null){
            double firstNumber = Double.parseDouble((String)data[0]);
            char operator = ((String) data[1]).charAt(0);
            double secondNumber = Double.parseDouble((String)data[2]);
            double result = 0;
            switch (operator){
                case MINUS:
                    result = calculator.sub(firstNumber, secondNumber);
                    break;
                case PLUS:
                    result = calculator.sum(firstNumber, secondNumber);
                    break;
                case DIV:
                    result = calculator.div(firstNumber, secondNumber);
                    break;
                case MULT:
                    result = calculator.mult(firstNumber, secondNumber);
                    break;
                default:
                    break;
            }
           return String.valueOf(result);
        } else {
            return "Invalid input string";
        }
    }
}
