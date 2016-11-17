package chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Logger {
    private String condition;
    Logger logger;

    void log(String message) {
        Pattern pattern = Pattern.compile(condition);
        Matcher matcher = pattern.matcher(message);
        if(matcher.matches()){
            System.out.println(matcher.group("message"));
        }
        if(logger != null){
            logger.log(message);
        }
    }

    void setNext(Logger logger) {
        this.logger = logger;
    }

    protected void setCondition(String condition){
        this.condition = condition;
    }
}
