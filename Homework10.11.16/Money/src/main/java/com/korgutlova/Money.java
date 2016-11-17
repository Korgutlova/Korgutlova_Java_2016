package com.korgutlova;

public class Money {
    final static int PRICEBAG = 3000;
    public static boolean checkMoney(int money) {
        return money > 0;
    }

    public static boolean buyBag(int money) {
        return PRICEBAG <= money;
    }
}