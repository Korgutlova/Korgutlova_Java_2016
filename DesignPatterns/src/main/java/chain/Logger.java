package chain;

abstract class Logger {

    Logger logger;
    abstract void log(String message);

    void setNext(Logger logger) {
        this.logger = logger;
    }

    void writeMessage(String message) {
        System.out.println(message);
    }
}
