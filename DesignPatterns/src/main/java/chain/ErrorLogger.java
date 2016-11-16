package chain;

public class ErrorLogger implements Logger {
    final static int ERROR = 3;
    Logger logger;

    @Override
    public void log(String message, int level) {
        if (level == ERROR){
            System.out.println("ERROR => " + message);
        }
    }

    @Override
    public void setNext(Logger logger) {
        this.logger = logger;
    }
}
