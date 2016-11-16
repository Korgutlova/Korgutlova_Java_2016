package chain;

public class Parser {
    final static String ERROR = "ERROR";
    final static String WARN = "WARN";
    final static String INFO = "INFO";

    public static int getLevel(String message) {
        if (message.charAt(0) == '[') {
            int index = 1;
            String mainWord = "";
            while (message.charAt(index) != ']') {
                mainWord += message.charAt(index);
                index += 1;
            }
            mainWord = mainWord.toUpperCase();
            switch (mainWord) {
                case ERROR:
                    return 3;
                case WARN:
                    return 2;
                case INFO:
                    return 1;
                default:
                    return -1;
            }
        }
        return -1;
    }
}
