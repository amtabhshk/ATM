package com.wipro.atm.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModifyUserFrame {

	JLabel entercardnol,selectusertypel,setpinl;
	JTextField entercardno,enterpin;
	JComboBox usertype;
	JButton modifyuser;
	JFrame modifyuserframe;
	public ModifyUserFrame() {
		
	modifyuserframe=new JFrame();
	modifyuserframe.setLayout(null);
     entercardnol=new JLabel("Enter Card No.");
     setpinl=new JLabel("Set Password");
     entercardno=new JTextField(40);
     enterpin=new JTextField(40);
     selectusertypel=new JLabel("Select User Type");
     usertype=new JComboBox();
     usertype.addItem("Select ...");
     usertype.addItem("admin");
     usertype.addItem("user");
     modifyuser=new JButton("Modify User");
     modifyuserframe.setTitle("Modify User");
     modifyuserframe.add(entercardnol).setBounds(50,50,100,30);
     modifyuserframe.add(entercardno).setBounds(180,50,150,30);
     modifyuserframe.add(setpinl).setBounds(50,100,100,30);
     modifyuserframe.add(enterpin).setBounds(180,100,150,30);
     modifyuserframe.add(selectusertypel).setBounds(50, 150,100,30);
    modifyuserframe.add(usertype).setBounds(230,150, 100,30);
    modifyuserframe.add(modifyuser).setBounds(150, 210,110, 30);
     modifyuserframe.setResizable(false);
	modifyuserframe.setVisible(true);
	modifyuserframe.setSize(450, 300);
	modifyuserframe.setLocation(400, 100);
		
	}
	public static void main(String aa[])
	{
		ModifyUserFrame mu=new ModifyUserFrame();
	}
}