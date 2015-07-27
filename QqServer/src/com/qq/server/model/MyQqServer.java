package com.qq.server.model;
/**
 * 这是QQ服务器
 * 他监听着等待某个QQ客户端来连接我们
 * @author Administrator
 *
 */
import javax.swing.*;

import com.qq.common.Message;
import com.qq.common.User;

import java.net.*;
import java.io.*;
import java.awt.*;
public class MyQqServer {

	
	public static void main(String[] args) {
		MyQqServer mqs=new MyQqServer();

	}
	public MyQqServer(){
		try {
			System.out.println("我是服务器，期在这里监听。。。");
			ServerSocket ss=new ServerSocket(8888);
			while(true){
				Socket s=ss.accept();  //阻塞等待客户端连接
				//接受客户端发来的信息
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u =(User) ois.readObject();
				System.out.println("fuwuqi"+u.getUserId()+u.getPasswd());
				Message m = new Message();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("123456")){
					//返回一个成功登陆的信息包
					m.setMesType("1");
					oos.writeObject(m);
					
					//这里就单开一个线程，让该线程与该客户端保持通讯。
					SerConClientThread scct = new SerConClientThread(s);
					//启动与该客户端通讯的线程
					scct.start();
					
				}else{
					m.setMesType("2");
					oos.writeObject(m);
					//关闭连接
					s.close();
				}
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
