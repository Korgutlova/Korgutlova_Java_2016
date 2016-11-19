package chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Logger {
    private String condition;
    Logger logger;

    public Logger(String condition){
        this.condition = condition;
    }
    public void log(String message) {
        Pattern pattern = Pattern.compile("^\\[" + condition + "\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])");
        Matcher matcher = pattern.matcher(message);
        if(matcher.matches()){
            System.out.println(matcher.group("message"));
        }
        if(logger != null){
            logger.log(message);
        }
    }

    public void setNext(Logger logger) {
        this.logger = logger;
    }
}
