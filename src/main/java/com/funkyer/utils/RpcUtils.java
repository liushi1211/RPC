package com.funkyer.utils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;

/**
 * Created by liushi on 17/8/25.
 */
public class RpcUtils
{
    public static String DEFAULT_VERSION = "0.0";

    public static String DEFAULT_GROUP = "default";


    public static String genExeKey(String serviceName,String version,String group)
    {
        if(version!=null)
        {
            return group+"_"+serviceName+"_"+version;
        }
        return serviceName;
    }

    public static Method findMethod(Class clazz, String name, Object[] args)
    {
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (m.getName().equals(name))
            {
                if(null != args)
                {
                      Class<?>[] argsClass = m.getParameterTypes();
                      for(int i=0;i<args.length;i++)
                      {
                          if(!StringUtils.equals(args[i].getClass().getName(),argsClass[i].getName()))
                          {
                              break;

                          }
                      }
                }
                else
                {
                    return m;
                }
            }
        }
        return null;
    }
}
