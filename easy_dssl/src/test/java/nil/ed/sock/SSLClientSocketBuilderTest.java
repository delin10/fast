package nil.ed.sock;

import nil.ed.utils.EasyPathBuilder;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SSLClientSocketBuilderTest {
    //@Test
    public void test0() throws IOException {
        SSLSocket sslSocket = new SSLClientSocketBuilder()
                .setHost("www.baidu.com")
                .setPort(443)
                .build();

        sslSocket.startHandshake();

        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                sslSocket.getOutputStream())));

        out.println("GET / HTTP/1.0");
        out.println();
        out.flush();

        /*
         * Make sure there were no surprises
         */
        if (out.checkError())
            System.out.println(
                    "SSLSocketClient:  java.io.PrintWriter error");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        sslSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);

        in.close();
        sslSocket.close();
    }

    // @Test
    public static void main(String[] args) throws Exception {
        Class<?> currentClass = SSLClientSocketBuilderTest.class;
        SSLSocket sslSocket = new SSLClientSocketBuilder()
                .configurer()
                .debug()
                .setTrustStorePath(EasyPathBuilder.getRootClassPathResource(currentClass, "client_trust.jks"))
                .setTrustStorePassword("client")
                .setKeyStorePath(EasyPathBuilder.getRootClassPathResource(currentClass, "client.jks"))
                .setKeyStorePassword("client")
                .config()
                .setHost("www.csdn.net")
                .setPort(443)
                .build();
        sslSocket.startHandshake();
        IEasyIOSocket easyIOSocket = new EasyIOSocketImpl(sslSocket);
        BufferedWriter writer = easyIOSocket.getBufferedWriter();
        //没有这个换行服务器报错
        writer.write("client ok\n");
        writer.flush();
        TimeUnit.SECONDS.sleep(2);
    }
}
