package com.qq.server.view;

import javax.swing.*;

import com.qq.server.model.MyQqServer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 这是服务器的控制界面
 * 启动服务器 关闭服务器
 * 可以管理和监控在线用户登录
 * @author Administrator
 *
 */
public class MyServerFrame extends JFrame implements ActionListener{

	JPanel jp1,jp2;
	JButton jb1,jb2;
	
	public static void main(String[] args) {
		MyServerFrame msf=new MyServerFrame();

	}
	public MyServerFrame(){
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(500,400);
		this.setLocation(300,200);
		this.setTitle("lovline。。");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			new MyQqServer();
		}
		
	}

}
