package com.funkyer.serialize;


public interface RpcSerializer {

	/**
	 * 序列化
	 * @param obj
	 * @return
	 */
	public byte[] serialize(Object obj);
	
	/**
	 * 反序列化
	 * @param bytes
	 * @return
	 */
	public Object deserialize(byte[] bytes);
	
}
