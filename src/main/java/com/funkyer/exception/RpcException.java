package com.funkyer.exception;


public class RpcException extends RuntimeException
{

	public RpcException(){
		super();
	}
	
	public RpcException(String message){
		super(message);
	}
	
	public RpcException(Throwable thr){
		super(thr);
	}

}
