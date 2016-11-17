package chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoLogger extends Logger {

    @Override
    public void log(String message) {
        Pattern pattern = Pattern.compile("^\\[((ERROR|INFO))\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])");
        Matcher matcher = pattern.matcher(message);
        if(matcher.matches()){
            writeMessage(matcher.group("message"));
        }
        if(logger != null){
            logger.log(message);
        }
    }
}
