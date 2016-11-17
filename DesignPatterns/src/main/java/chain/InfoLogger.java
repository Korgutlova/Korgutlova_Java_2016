package chain;

public class InfoLogger extends Logger {
    public InfoLogger(){
        setCondition("^\\[(ERROR|INFO)\\] : (?<message>\\[[a-zA-Z -_0-9]*\\])");
    }
}
