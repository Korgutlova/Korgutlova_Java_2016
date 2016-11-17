package chain;

public class ErrorLogger extends Logger {

    public ErrorLogger(){
        setCondition("^\\[ERROR\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])");
    }
}
