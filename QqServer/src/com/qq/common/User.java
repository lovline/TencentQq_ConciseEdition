package com.qq.common;

import java.io.Serializable;

/**
 * 这是用户信息类
 * @author Administrator
 *
 */
public class User implements Serializable{
	private String userId;
	private String passwd;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
