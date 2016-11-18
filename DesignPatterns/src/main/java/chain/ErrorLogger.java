package chain;

public class ErrorLogger extends Logger {

    public ErrorLogger(){
        condition = "^\\[ERROR\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])";
    }
}
