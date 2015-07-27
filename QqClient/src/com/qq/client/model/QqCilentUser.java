package com.qq.client.model;

import com.qq.common.User;

public class QqCilentUser {

	public boolean checkUser(User u){
		return new QqClientConServer().SendLoginInfoToServer(u);
		
	}
}
