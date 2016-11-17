package com.korgutlova;

public class Client {

    private final String name;
    private int money;

    public Client(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public boolean buySomething(int money, String market) {
        if (Market.checkMarket(market, money).equals("yes")) {
            if (Money.buyBag(money) && this.getMoney() >= money) {
                this.setMoney(this.getMoney() - money);
                return true;
            }
        }
        return false;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }
}
