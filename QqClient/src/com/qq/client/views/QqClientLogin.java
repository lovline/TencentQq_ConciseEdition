package com.qq.client.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.qq.client.model.QqCilentUser;
import com.qq.common.User;

public class QqClientLogin extends JFrame implements ActionListener{

	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl8,jl9;
	JButton jb1,jb2,jb3,jb4;
	JTextField jtf;
	JPasswordField jpf;
	JCheckBox jcb1,jcb2;
	
	public static void main(String[] args) {
		QqClientLogin qqcl=new QqClientLogin();

	}
	
	public QqClientLogin(){
		jl1=new JLabel(new ImageIcon("images/tou.gif"));
		jl2=new JLabel("QQ∫≈¬Î",JLabel.CENTER);
		jl3=new JLabel("QQ√‹¬Î",JLabel.CENTER);
		jtf=new JTextField(8);
		jpf=new JPasswordField(8);
		jb1=new JButton(new ImageIcon("images/clear.gif"));
		jl8=new JLabel("Õ¸º«√‹¬Î",JLabel.CENTER);
		jl8.setForeground(Color.blue);
		jl8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jl9=new JLabel("…Í«Î√‹¬Î±£ª§",JLabel.CENTER);
		jl9.setForeground(Color.blue);
		jl9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jcb1=new JCheckBox("“˛…Ìµ«¬Ω");
		jcb2=new JCheckBox("º«◊°√‹¬Î");
		
		jp1=new JPanel();
		jp1.add(jl2);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jl3);
		jp1.add(jpf);
		jp1.add(jl8);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jl9);
		
		jb2=new JButton(new ImageIcon("images/denglu.gif"));
		jb2.addActionListener(this);
		jb3=new JButton(new ImageIcon("images/quxiao.gif"));
		jb4=new JButton(new ImageIcon("images/xiangdao.gif"));
		
		jp2=new JPanel();
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		
		this.add(jl1,"North");
		jp1.setLayout(new GridLayout(3,3));
		this.add(jp1,"Center");
		this.add(jp2,"South");
		
		this.setSize(350,200);
		this.setLocation(400,240);
		this.setTitle("qqChat°£°£");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb2){
			QqCilentUser qu = new QqCilentUser();
			User u = new User();
			u.setUserId(jtf.getText().trim());
			u.setPasswd(new String(jpf.getPassword()));
			if(qu.checkUser(u)){
				new QqFriendList(u.getUserId());
				//πÿ±’µ«¬ΩΩÁ√Ê
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "”√ªß√‹¬Î¥ÌŒÛ");
			}
		}
	}

}
