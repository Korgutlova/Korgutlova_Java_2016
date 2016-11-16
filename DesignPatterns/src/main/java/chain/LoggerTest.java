package chain;
import java.util.ArrayList;
import java.util.List;

public class LoggerTest {
    public static void main(String[] args) {

        Logger logger = new InfoLogger();
        Logger warnLogger = new WarnLogger();
        Logger errorLogger = new ErrorLogger();

        warnLogger.setNext(errorLogger);
        logger.setNext(warnLogger);

        String infoMessage = "[INFO] : [some info here]";
        String warnMessage = "[WARN] : [warning]";
        String errorMessage = "[ERROR] : [exception in some modules]";
        String invalidMessage = "[LOL] : [lol lol]";

        List<String> messages = new ArrayList<>();
        messages.add(infoMessage);
        messages.add(warnMessage);
        messages.add(errorMessage);
        messages.add(invalidMessage);

        //messages.stream().map(message -> logger.log(message));

        //Output shoul looks this way:
        //[some info here]
        //[warning]
        //[exception in some modules]
        //[exception in some modules]

    }
}