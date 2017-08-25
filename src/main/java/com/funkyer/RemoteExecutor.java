package com.funkyer;


/**
 * rpc请求执行，客户端代理执行，服务提供端真正执行
 * @author lindezhi
 * 2016年3月9日 上午11:27:06
 */
public interface RemoteExecutor
{
	
	/**
	 * 无返回值执行，无论是否异常
	 * @param call
	 */
	public void oneway(RemoteCall call);
	
	/**
	 * 有返回值执行
	 * @param call
	 * @return
	 */
	public Object invoke(RemoteCall call);
	

}
