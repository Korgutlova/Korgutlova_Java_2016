package chain;

public class WarnMessage implements Message{
    private String text;

    public WarnMessage(String text){
        this.text = text;
    }

    public String showInfo() {
        return "[WARN]" + this.text;
    }
}
