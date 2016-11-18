package chain;


public class WarnLogger extends Logger {

    public WarnLogger(){
        condition = "^\\[WARN\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])";
    }
}
