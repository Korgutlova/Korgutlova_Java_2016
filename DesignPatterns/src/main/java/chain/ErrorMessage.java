package chain;

public class ErrorMessage implements Message{
    private String text;

    public ErrorMessage(String text){
        this.text = text;
    }

    public String showInfo() {
        return "[ERROR]" + this.text;
    }
}
