package nil.ed.sock;

import java.io.*;

/**
 * 包装Socket IO流
 */
public interface IEasyIOSocket {
    /**
     *一般实现依赖getWriter
     * @return
     * @throws IOException
     */
    BufferedWriter getBufferedWriter() throws IOException;

    /**
     *必须实现
     * @return
     * @throws IOException
     */
    OutputStreamWriter getWriter() throws IOException;

    /**
     * 可选实现
     * @return
     * @throws IOException
     */
    PrintWriter getPrintWriter() throws IOException;

    /**
     * 必须实现
     * @return
     * @throws IOException
     */
    OutputStream getRawOutputStream() throws IOException;

    /**
     * 必须实现
     * @return
     * @throws IOException
     */
    InputStreamReader getReader() throws IOException;

    /**
     * 可选择依赖getReader
     * @return
     * @throws IOException
     */
    BufferedReader getBufferedReader() throws IOException;

    /**
     * 必须实现
     * @return
     * @throws IOException
     */
    InputStream getRawInputStream() throws IOException;
}
