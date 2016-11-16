package chain;

public class InfoLogger implements Logger {
    final static int LEVEL = 1;
    Logger logger;

    @Override
    public void setNext(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {

    }

}
