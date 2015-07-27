package com.qq.client.views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.*;

import com.qq.client.model.QqClientConServer;
import com.qq.common.Message;

/**
 * 这是与好友聊天的界面
 * @author Administrator
 *
 */
public class QqChat extends JFrame implements ActionListener{

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String owerId;
	String friendId;
	
	public static void main(String[] args) {
		//QqChat qqc=new QqChat("");

	}
	public QqChat(String owerId,String friend){
		
		this.owerId = owerId;
		this.friendId = friend;
		
		jta=new JTextArea();
		jtf=new JTextField(18);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta);
		this.add(jp,"South");
		
		this.setSize(350,270);
		this.setLocation(500,150);
		this.setTitle(owerId+"。。正在和"+ friend +"。。聊天");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setResizable(false);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb){
			//如果用户点击了发送按钮。
			Message m = new Message();
			m.setSender(this.owerId);
			m.setGetter(this.friendId);
			m.setContent(jtf.getText());
			m.setSendTime(new Date().toString()); 
			//发送给服务器
			try {
				ObjectOutputStream oos = new ObjectOutputStream(QqClientConServer.s.getOutputStream());
				oos.writeObject(m);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
		}
		
	}

}
