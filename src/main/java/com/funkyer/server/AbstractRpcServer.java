package com.funkyer.server;

/**
 * Created by liushi on 17/8/25.
 */
public abstract class AbstractRpcServer extends AbstractRpcNetworkBase
{
    /**
     * 业务remote api注册与执行代理
     */
    private SimpleServerRemoteExecutor proxy = new SimpleServerRemoteExecutor();
    /**
     * 注册为rpc服务
     * @param serviceName
     * @param ifaceImpl
     */
    public void register(String serviceName,Object ifaceImpl)
    {
        this.register(serviceName,ifaceImpl,null);
    }

    /**
     * 注册一个服务为rpc服务
     * @param serviceName
     * @param ifaceImpl
     * @param version
     */
    public void register(String serviceName,Object ifaceImpl,String version)
    {
        this.register(serviceName, ifaceImpl, version,null);
    }

    /**
     * 添加组的支持
     * @param serviceName
     * @param ifaceImpl
     * @param version
     * @param group
     */
    public void register(String serviceName,Object ifaceImpl,String version,String group)
    {
        proxy.registerRemoteService(serviceName,ifaceImpl,version,group);
    }
}
