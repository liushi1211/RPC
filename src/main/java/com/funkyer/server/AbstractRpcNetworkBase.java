package com.funkyer.server;

/**
 * Created by liushi on 17/8/25.
 */
public abstract class AbstractRpcNetworkBase
{
    /**
     * ip服务端表示绑定ip，客户端表示连接到服务器的监听ip
     */
    private String host;

    /**
     * 端口服务端表示绑定端口，客户端表示连接到服务端的监听端口
     */
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public abstract void startService();

    public abstract void stopService();
}
