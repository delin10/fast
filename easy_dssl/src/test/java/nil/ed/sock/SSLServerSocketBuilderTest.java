package nil.ed.sock;

import nil.ed.utils.EasyPathBuilder;
import org.junit.Test;

import javax.net.ssl.SSLServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SSLServerSocketBuilderTest {
    //@Test
    public void test() throws Exception {
        Class<?> currentClass = SSLServerSocketBuilderTest.class;
        SSLServerSocket sslServerSocket = new SSLServerSocketBuilder().configurer()
                .debug()
                .setTrustStorePath(EasyPathBuilder.getRootClassPathResource(currentClass, "server_trust.jks"))
                .setTrustStorePassword("server")
                .setKeyStorePath(EasyPathBuilder.getRootClassPathResource(currentClass, "server.jks"))
                .setKeyStorePassword("server")
                .config()
                .setPort(12001)
                .build();
        sslServerSocket.setNeedClientAuth(false);
        Thread thread = new Thread(() -> {
            try {

                Socket socket = sslServerSocket.accept();
                IEasyIOSocket easyIOSocket = new EasyIOSocketImpl(socket);
                BufferedReader reader = easyIOSocket.getBufferedReader();
                System.out.println(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
    }
}
