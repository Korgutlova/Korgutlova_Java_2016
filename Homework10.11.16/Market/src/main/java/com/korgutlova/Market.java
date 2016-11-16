package com.korgutlova;

public class Market {
    public static String checkMarket(String nameMarket, int money) {
        String isWork;
        switch (nameMarket) {
            case "GUM":
                isWork = "yes";
                break;
            case "5-ka":
                isWork = "no";
                break;
            case "Ashan":
                isWork = "closes";
                break;
            default:
                isWork = "no";
        }
        if (Money.checkMoney(money)) {
            return isWork;
        }
        return "NoMoneyForMarket";
    }
}