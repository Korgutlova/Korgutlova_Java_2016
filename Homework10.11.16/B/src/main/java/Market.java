public class Market {
    public static int checkMarket(String nameMarket, int money) {
        int flag;
        switch (nameMarket) {
            case "GUM":
                flag = 2;
                break;
            case "5-ka":
                flag = 1;
                break;
            case "Ashan":
                flag = 2;
                break;
            default:
                flag = 0;
        }
        if(Money.checkMoney(money)){
            return flag;
        }
        return -1;
    }
}