package com.korgutlova;

public class Market {
    final static String GUM = "GUM";
    final static String ASHAN = "Ashan";
    final static String MAGNIT = "Magnit";

    public static String checkMarket(String nameMarket, int money) {
        String isWork;
        switch (nameMarket) {
            case GUM:
                isWork = "yes";
                break;
            case MAGNIT:
                isWork = "no";
                break;
            case ASHAN:
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