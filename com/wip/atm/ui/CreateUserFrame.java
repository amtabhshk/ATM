package com.wipro.atm.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wipro.atm.listener.BoxListener;
import com.wipro.atm.listener.ButtonListener;

public class CreateUserFrame {

	JLabel entercardnol,selectusertypel;
	public JTextField entercardno;
	public JComboBox usertype;
	JButton createuser;
	JFrame createuserframe;
	public CreateUserFrame() {
		
	createuserframe=new JFrame();
	createuserframe.setLayout(null);
     entercardnol=new JLabel("Enter Card No.");
     entercardno=new JTextField(40);
     selectusertypel=new JLabel("Select User Type");
     usertype=new JComboBox();
     usertype.addItem("Select ...");
     usertype.addItem("admin");
     usertype.addItem("user");
     createuser=new JButton("Create User:");
     createuser.addActionListener(new ButtonListener());
     
     createuserframe.setTitle("Create User");
     createuserframe.add(entercardnol).setBounds(50,50,100,30);
     createuserframe.add(entercardno).setBounds(180,50,150,30);
     createuserframe.add(selectusertypel).setBounds(50, 100,100,30);
     createuserframe.add(usertype).setBounds(230,100, 100,30);
     createuserframe.add(createuser).setBounds(145, 180,110, 30);
     createuserframe.setResizable(false);
	createuserframe.setVisible(true);
	createuserframe.setSize(400, 300);
	createuserframe.setLocation(400, 100);
	usertype.addItemListener(new BoxListener(this));
		
	}
	public static void main(String aa[])
	{
		CreateUserFrame cu=new CreateUserFrame();
	}
}