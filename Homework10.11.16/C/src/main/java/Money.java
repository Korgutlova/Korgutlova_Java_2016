public class Money {
    public static boolean checkMoney(int money) {
        return money > 0;
    }

    public static boolean buyBag(int money) {
        int defaultPrice = 3000;
        return defaultPrice <= money;
    }
}