package com.wipro.atm.ui;
import java.awt.FlowLayout;

import javax.swing.*;

import com.wipro.atm.listener.ButtonListener;
public class Login {
	public static JFrame login;
	public JTextField useridtf;
	public JPasswordField password;
	JLabel useridl,passwordl;
	JButton loginb;
	Login lob;
	
	public Login()
	{
		//login UI//
		login=new JFrame("welcome to login");
		useridtf=new JTextField(10);
		password=new JPasswordField();
		useridl=new JLabel("USER ID");
		passwordl=new JLabel("PASSWORD");
		loginb=new JButton("LOGIN");
		login.setLayout(null);
		login.setVisible(true);
		login.setSize(500,500);
		
		login.add(useridl);
		useridl.setBounds(76,50,60,20);
		login.add(useridtf);
		useridtf.setBounds(150,50,150,20);
		login.add(passwordl);
		passwordl.setBounds(50,75,100,20);
		login.add(password);
		password.setBounds(150,75,150,20);
		login.add(loginb);
		loginb.setBounds(175,100,80,20);
		loginb.addActionListener(new ButtonListener(this));
	//-----------------------------------------------------------
		
		
		
		
		
		
		
	}
	public static void main(String arg[])
	{
		Login lob=new Login();
	}
}
