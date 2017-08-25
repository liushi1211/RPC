package com.funkyer.server;

import com.funkyer.RemoteCall;
import com.funkyer.RemoteExecutor;
import com.funkyer.RpcServiceBean;
import com.funkyer.exception.RpcException;
import com.funkyer.utils.RpcUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liushi on 17/8/25.
 */
public class SimpleServerRemoteExecutor implements RemoteExecutor
{
    protected ConcurrentHashMap<String,RpcServiceBean> exeCache = new ConcurrentHashMap<String,RpcServiceBean>();
    /**
     * 当前应用
     */
    private String application;

    public void registerRemoteService(String serviceName,Object ifaceImpl,String version,String group)
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


        exeCache.put(RpcUtils.genExeKey(serviceName, version,group), new RpcServiceBean(serviceName,ifaceImpl,version,getApplication(),group));

    }



    public String getApplication()
    {
        return application;
    }

    public void setApplication(String application)
    {
        this.application = application;
    }

    @Override
    public void oneway(RemoteCall call)
    {
        TaskExecutor.executeTask(findService(call),call.getMethod(),call.getArgs());

    }

    @Override
    public Object invoke(RemoteCall call)
    {
        return TaskExecutor.executeTask(findService(call),call.getMethod(),call.getArgs());
    }



    /**
     * 通过service和版本找到实现对象
     * @param call
     * @return
     */
    private Object findService(RemoteCall call){
        String exeKey = RpcUtils.genExeKey(call.getService(), call.getVersion(),call.getGroup());
        RpcServiceBean object = exeCache.get(exeKey);
        if(object==null||object.getBean()==null){
            throw new RpcException("group:"+call.getGroup()+" service:"+call.getService()+" version:"+call.getVersion()+" not exist");
        }
        return object.getBean();
    }
}
