package chain;

public class ErrorLogger implements Logger{
    final static int LEVEL = 3;
    Logger logger;

    @Override
    public void setNext(Logger logger) {
        this.logger = logger;
    }


    @Override
    public void log(String message) {
        if(Parser.getLevel(message) == 3) {
            System.out.println("EEROR => " + message);
        } else {
            System.out.println("Oops");
        }
    }

}
