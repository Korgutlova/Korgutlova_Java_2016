package chain;

public class Logger {
    private Message message;

    public Logger(Message message){
        this.message = message;
    }

    public void getMessage(){
        System.out.println(message.showInfo());
    }
}
