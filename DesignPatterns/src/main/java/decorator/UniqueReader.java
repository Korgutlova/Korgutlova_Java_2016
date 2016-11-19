package decorator;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class UniqueReader extends FilterReader {

    protected UniqueReader(Reader in) {
        super(in);
    }

    private char transform(char x) {
        char[] arr = {'e', 'u', 'o', 'a', 'y', 'i'};
        for (char ch : arr) {
            if (x == ch) {
                return '#';
            }
        }
        return x;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int result = super.read(cbuf, off, len);
        for (int i = off; i < off + result; i++) {
            cbuf[i] = transform(cbuf[i]);
        }
        return result;
    }

    @Override
    public int read() throws IOException {
        int i = super.read();
        char symbol = transform((char) i);
        return i != -1 ? symbol : i;
    }

}
