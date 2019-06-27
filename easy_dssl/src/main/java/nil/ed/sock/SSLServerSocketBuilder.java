package nil.ed.sock;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;

/**
 * 创建SSLServerSocket
 * 示例
 * <p>
 * SSLSocket sslSocket = new SSLClientSocketBuilder()
 * .configurer()
 * .debug()
 * .setTrustStorePath(EasyPathBuilder.getRootClassPathResource(currentClass, "client_trust.jks"))
 * .setTrustStorePassword("client")
 * .setKeyStorePath(EasyPathBuilder.getRootClassPathResource(currentClass, "client.jks"))
 * .setKeyStorePassword("client")
 * .config()
 * .setHost("127.0.0.1")
 * .setPort(12001)
 * .build();
 */
public class SSLServerSocketBuilder {
    private SSLEnvironmentConfigurer<SSLServerSocketBuilder> configurer;
    private int port;

    public SSLServerSocketBuilder() {
        this.configurer = new SSLEnvironmentConfigurer<>(this);
    }

    /**
     * 获取配置管理器，必须配置trustStore，store和相应密码
     * @return
     */
    public SSLEnvironmentConfigurer<SSLServerSocketBuilder> configurer() {
        return configurer;
    }

    /**
     * 设置监听端口
     * @param port
     * @return
     */
    public SSLServerSocketBuilder setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * 创建ServerSocket
     * @return
     * @throws IOException
     */
    public SSLServerSocket build() throws IOException {
        return (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(port);
    }
}
