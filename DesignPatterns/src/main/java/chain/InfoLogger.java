package chain;

public class InfoLogger implements Logger {
    final static int INFO = 1;
    final static int ERROR = 3;
    Logger logger;

    @Override
    public void log(String message, int level) {
        if(level == INFO){
            System.out.println("INFO => " + message);
        } else if (level == ERROR){
            System.out.println("INFO => " + message);
            logger.log(message, level);
        } else {
            logger.log(message, level);
        }
    }

    @Override
    public void setNext(Logger logger) {
        this.logger = logger;
    }
}
