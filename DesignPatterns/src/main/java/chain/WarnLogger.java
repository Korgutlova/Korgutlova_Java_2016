package chain;

public class WarnLogger implements Logger {
    final static int WARN = 2;
    Logger logger;

    @Override
    public void log(String message, int level) {
        if(level == WARN){
            System.out.println("WARN => " + message);
        } else {
            logger.log(message, level);
        }
    }

    @Override
    public void setNext(Logger logger) {
        this.logger = logger;
    }
}
