package chain;


public class WarnLogger extends Logger {

    public WarnLogger(){
        setCondition("^\\[WARN\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])");
    }
}
