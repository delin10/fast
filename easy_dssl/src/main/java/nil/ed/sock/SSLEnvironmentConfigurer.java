package nil.ed.sock;

import nil.ed.utils.ParamChecker;

/**
 * SSL配置管理器
 * @param <T> 一般为SSLClientSocketBuilder和SSLServerSocketBuilder
 */
public class SSLEnvironmentConfigurer<T> {
    private String keyStorePath;
    private String keyStorePassword;
    private String trustStorePath;
    private String trustStorePassword;
    private T builder;

    SSLEnvironmentConfigurer(T builder) {
        this.builder = builder;
    }

    /**
     * 必须配置密钥库
     * @param keyStorePath 密钥库路径
     * @return
     */
    public SSLEnvironmentConfigurer<T> setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
        return this;
    }

    /**
     * 必须配置密钥库密码
     * @param keyStorePassword
     * @return
     */
    public SSLEnvironmentConfigurer<T> setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
        return this;
    }

    /**
     * 必须配置信任密钥库路径
     * @param trustStorePath
     * @return
     */
    public SSLEnvironmentConfigurer<T> setTrustStorePath(String trustStorePath) {
        this.trustStorePath = trustStorePath;
        return this;
    }

    /**
     * 必须配置信任密钥库密码
     * @param trustStorePassword
     * @return
     */
    public SSLEnvironmentConfigurer<T> setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
        return this;
    }

    /**
     * 可选配置debug模式
     * @return
     */
    public SSLEnvironmentConfigurer<T> debug() {
        System.setProperty("javax.net.debug", "ssl,handshake");
        return this;
    }

    public T config() {
        ParamChecker.checkNullAndThrows(keyStorePath, "keyStorePath is null");
        ParamChecker.checkNullAndThrows(keyStorePassword, "keyStorePassword is null");
        ParamChecker.checkNullAndThrows(trustStorePath, "trustStorePath is null");
        ParamChecker.checkNullAndThrows(trustStorePassword, "trustStorePassword is null");

        System.setProperty("javax.net.ssl.keyStore", keyStorePath);
        System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
        System.setProperty("javax.net.ssl.trustStore", trustStorePath);
        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
        return builder;
    }
}
