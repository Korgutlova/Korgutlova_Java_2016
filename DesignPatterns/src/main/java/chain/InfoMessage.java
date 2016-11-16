package chain;

public class InfoMessage implements Message {
    private String text;

    public InfoMessage(String text) {
        this.text = text;
    }

    public String showInfo() {
        return "[INFO]" + this.text;
    }
}
