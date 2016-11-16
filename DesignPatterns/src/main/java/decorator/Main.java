package decorator;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream is = new UniqueReader(new BufferedInputStream(new FileInputStream("test.txt")));
        while(is.available() != 0) {
            System.out.print((char) is.read());
        }
    }
}
