package decorator;

import java.io.CharArrayReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UniqueReader extends FilterInputStream{


    private char transform(char x) {
        char [] arr = {'e', 'u', 'o', 'a', 'y', 'i'};
        for(char ch : arr){
            if(x == ch){
                return '#';
            }
        }
        return x;
    }

    @Override
    public int read() throws IOException {
        int i = super.read();
        char symbol = transform((char) i);
        return i != - 1 ? symbol : i;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) transform((char) b[i]);
        }
        return result;
    }

    protected UniqueReader(InputStream in) {
        super(in);
    }
}
