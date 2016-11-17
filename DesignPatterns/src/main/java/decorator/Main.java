package decorator;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new UniqueReader(new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("test.txt")));
        while(reader.ready()) {
            System.out.print((char) reader.read());
        }
    }
}
