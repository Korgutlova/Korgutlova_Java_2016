package chain;

public class Parser {
    public static void getText(String text) {
        Logger loggerError;
        Logger loggerInfo;
        Logger loggerWarn;
        int i = 1;
        String mainWord = "";
        while (text.charAt(i) != ']') {
            mainWord += text.charAt(i);
            i += 1;
        }
        i += 1;
        text = text.substring(i);
        mainWord = mainWord.toUpperCase();
        if (mainWord.equals("ERROR")) {
            loggerError = new Logger(new ErrorMessage(text));
            loggerError.getMessage();
            loggerInfo = new Logger(new InfoMessage(text));
            loggerInfo.getMessage();
        } else if (mainWord.equals("WARN")) {
            loggerWarn = new Logger(new WarnMessage(text));
            loggerWarn.getMessage();
        } else{
            loggerInfo = new Logger(new InfoMessage(text));
            loggerInfo.getMessage();
        }
    }
}
