package com.funkyer;

import java.io.Serializable;

/**
 * rpc服务接口版本，实现对象
 * @author lindezhi
 * 2016年3月9日 上午11:15:00
 */
public class RpcServiceBean implements Serializable {

	private static final long serialVersionUID = -1840492630641710459L;

	/**
	 * remote接口class
	 */
	private String serviceName;
	
	/**
	 * remote接口class版本
	 */
	private String version;
	
	/**
	 * interf实现对象
	 */
	private Object bean;

	/**
	 * 所属应用
	 */
	private String application;

	/**
	 * 分组
	 */
	private String group;

	public RpcServiceBean(String serviceName, Object bean, String version, String application, String group) {
		this.serviceName = serviceName;
		this.bean = bean;
		this.version = version;
		this.application = application;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
