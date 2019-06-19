package nil.ed.iox;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferInputStream extends InputStream {
    private ByteBuffer buffer;
    private int cursor = 0;
    private int length;

    /**
     * @param buffer 载入流中的缓冲区
     * @param length 缓冲区里的数据大小
     */
    public ByteBufferInputStream(ByteBuffer buffer, int length) {
        this.buffer = buffer;
        this.length = length;
    }

    /**
     * 类似于ByteArrayInputStream
     *
     * @return 大于等于0小于256
     * @throws IOException
     */
    @Override
    public int read() throws IOException {
        if (cursor >= length) {
            throw new EOFException();
        }
        //参考InputStream实现可知
        return buffer.get(cursor++) & 0xff;
    }
}
