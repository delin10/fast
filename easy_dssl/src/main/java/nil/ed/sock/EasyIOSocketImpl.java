package nil.ed.sock;

import java.io.*;
import java.net.Socket;

public class EasyIOSocketImpl implements IEasyIOSocket {
    private Socket socket;

    public EasyIOSocketImpl(Socket socket) {
        this.socket = socket;
    }

    @Override
    public BufferedWriter getBufferedWriter() throws IOException {
        return new BufferedWriter(getWriter());
    }

    @Override
    public PrintWriter getPrintWriter() throws IOException {
        return new PrintWriter(getWriter());
    }

    @Override
    public OutputStream getRawOutputStream() throws IOException {
        return socket.getOutputStream();
    }

    @Override
    public OutputStreamWriter getWriter() throws IOException {
        return new OutputStreamWriter(getRawOutputStream());
    }

    @Override
    public InputStreamReader getReader() throws IOException {
        return new InputStreamReader(getRawInputStream());
    }

    @Override
    public BufferedReader getBufferedReader() throws IOException {
        return new BufferedReader(getReader());
    }

    @Override
    public InputStream getRawInputStream() throws IOException {
        return socket.getInputStream();
    }
}