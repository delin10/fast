package nil.ed.sock;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

/**
 * 创建客户端SSLSocket
 *
 *
 */
public class SSLClientSocketBuilder {
    private SSLEnvironmentConfigurer<SSLClientSocketBuilder> configurer;
    private int port;
    private String host;

    public SSLClientSocketBuilder() {
        this.configurer = new SSLEnvironmentConfigurer<>(this);
    }

    /**
     * 获取环境变量配置器
     * @return 用于环境变量配置
     */
    public SSLEnvironmentConfigurer<SSLClientSocketBuilder> configurer() {
        return configurer;
    }

    /**
     * 设置服务器端口
     * @param port
     * @return
     */
    public SSLClientSocketBuilder setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * 配置服务器主机地址
     * @param host
     * @return
     */
    public SSLClientSocketBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public SSLSocket build() throws IOException {
        return (SSLSocket) SSLSocketFactory.getDefault().createSocket(host, port);
    }
}
