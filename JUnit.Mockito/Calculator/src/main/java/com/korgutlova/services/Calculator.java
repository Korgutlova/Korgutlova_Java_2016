package com.korgutlova.services;

public class Calculator {
    public double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double sub(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double mult(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double div(double firstNumber, double secondNumber) {
        if(secondNumber == 0){
            throw new ArithmeticException("You can not divide by zero");
        }
        return firstNumber / secondNumber;
    }
}
