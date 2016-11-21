package chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Logger {
    private String condition;
    Logger nextLogger;

    public Logger(Level... level) {
        String or = "|";
        condition = "";
        for (Level lvl : level) {
            condition += lvl + or;
        }
        condition = condition.substring(0, condition.length() - 1);
    }

    public void log(String message) {
        Pattern pattern = Pattern.compile("^\\[(" + condition + ")\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])");
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()) {
            System.out.println(matcher.group("message"));
        }
        if (nextLogger != null) {
            nextLogger.log(message);
        }
    }

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }
}
