package chain;

public class InfoLogger extends Logger {
    public InfoLogger(){
        condition = "^\\[(ERROR|INFO)\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])";
    }
}
