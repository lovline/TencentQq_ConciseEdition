package com.qq.client.tools;
/**
 * 这是客户端和服务器端保持通讯的线程
 */
import java.net.Socket;
import java.io.*;

import com.qq.common.Message;

public class ClientConServerThread extends Thread{
	
	private Socket s;
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
	public ClientConServerThread(Socket s){
		this.s = s;
	}
	public void run(){
		while(true){
			//从服务器端发来的消息
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message) ois.readObject();
				System.out.println(m.getContent()+m.getGetter()+m.getSender());
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
