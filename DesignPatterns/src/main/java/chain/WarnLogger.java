package chain;

public class WarnLogger implements Logger{
    final static int LEVEL = 2;
    Logger logger;

    @Override
    public void log(String message) {

    }

    @Override
    public void setNext(Logger logger) {
        this.logger = logger;
    }
}
