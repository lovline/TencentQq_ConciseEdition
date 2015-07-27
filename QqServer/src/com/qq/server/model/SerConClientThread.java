package com.qq.server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.qq.common.Message;

/**
 * 功能是服务器和某个客户护短的通讯线程
 * @author Administrator
 */
public class SerConClientThread extends Thread {

	Socket s;
	
	public SerConClientThread(Socket s){
		//把服务器与该客户端的连接赋给S
		this.s = s;
	}
	
	public void run(){
		while(true){
			//这里该线程就可以接受客户端的信息
			
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message) ois.readObject();
				System.out.println(m.getSender()+m.getGetter()+m.getContent());
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
		}
	}
	
}
