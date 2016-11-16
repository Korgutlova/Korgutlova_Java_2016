package chain;

public interface Logger {
    void log(String message, int level);

    void setNext(Logger logger);
}
