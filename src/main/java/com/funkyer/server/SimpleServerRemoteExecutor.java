package com.funkyer.server;

import com.funkyer.RpcServiceBean;
import com.funkyer.exception.RpcException;
import com.funkyer.utils.RpcUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liushi on 17/8/25.
 */
public class SimpleServerRemoteExecutor
{
    protected ConcurrentHashMap<String,RpcServiceBean> exeCache = new ConcurrentHashMap<String,RpcServiceBean>();
    /**
     * 当前应用
     */
    private String application;

    private void registerRemoteService(String serviceName,Object ifaceImpl,String version,String group)
    {
        Object service = exeCache.get(serviceName);
        if(service!=null&&service!=ifaceImpl){
            throw new RpcException("can't register service "+serviceName+" again");
        }
        if(ifaceImpl==service||ifaceImpl==null){
            return;
        }
        if(version==null){
            version= RpcUtils.DEFAULT_VERSION;
        }

        //默认分组
        if(group==null){
            group = RpcUtils.DEFAULT_GROUP;
        }


        exeCache.put(this.genExeKey(serviceName, version,group), new RpcServiceBean(serviceName,ifaceImpl,version,application,group));

    }

    private String genExeKey(String serviceName,String version,String group)
    {
        if(version!=null)
        {
            return group+"_"+serviceName+"_"+version;
        }
        return serviceName;
    }
}
