package com.funkyer.server;

import com.funkyer.exception.RpcException;
import com.funkyer.utils.RpcUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushi on 17/8/25.
 */
public class TaskExecutor
{
    private static Map<String, Method> methodCache = new HashMap<String, Method>();

    public static Object executeTask(Object service, String methodName, Object[] args)
    {
        Class<? extends Object> clazz = service.getClass();
        String key = clazz.getCanonicalName() + "." + methodName;
        Method method = methodCache.get(key);
        if (method == null) {
            method = RpcUtils.findMethod(clazz, methodName, args);
            if (method == null) {
                throw new RpcException("method not exist method:" + methodName);
            }
            methodCache.put(key, method);
        }
        try {
            return method.invoke(service, args);
        } catch (IllegalAccessException e) {
            throw new RpcException("invoke IllegalAccess request access error");
        } catch (IllegalArgumentException e) {
            throw new RpcException("invoke IllegalArgument request param wrong");
        } catch (InvocationTargetException e) {
            throw new RpcException("rpc invoke target error");
        }


    }
}
