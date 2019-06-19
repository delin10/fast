package nil.ed.iox;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferOutputStream extends OutputStream {
    private ByteBuffer buffer;
    private int cursor = 0;
    private int length;

    public ByteBufferOutputStream(ByteBuffer buffer, int length) {
        this.buffer = buffer;
        this.length = length;
    }

    @Override
    public void write(int x) throws IOException {
        if (buffer.isReadOnly()) {
            throw new EOFException();
        }
        buffer.put((byte) x);
    }
}
