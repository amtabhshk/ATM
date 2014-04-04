package com.wipro.atm.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.wipro.atm.listener.ButtonListener;

public class AddBranchDetailFrame {
	public static JFrame addbranchdetailframe;
	public JTextField branchname,branchid;
	public JTextArea branchaddress;
	JButton addbranch; 
	JLabel branchnamel,branchidl,branchaddressl;
	
	public AddBranchDetailFrame()
	{
		addbranchdetailframe=new JFrame();
		addbranchdetailframe.setTitle("Add Branch Details");
		branchname=new JTextField(40);
		branchaddress=new JTextArea(40,40);
		branchid=new JTextField(40);
		addbranch= new  JButton("Add Branch:");
		branchnamel=new JLabel("Branch Name");
		branchidl=new JLabel("Branch Id");
		branchaddressl=new JLabel("Branch Address");
		addbranchdetailframe.setLayout(null);
		addbranchdetailframe.add(branchnamel).setBounds(40,40,200,30);
		addbranchdetailframe.add(branchname).setBounds(150, 40,300,30);
		addbranchdetailframe.add(branchidl).setBounds(40,80, 200,30);
		addbranchdetailframe.add(branchid).setBounds(150, 80, 300,30);
		addbranchdetailframe.add(branchaddressl).setBounds(40, 120,200,30);
		addbranchdetailframe.add(branchaddress).setBounds(150,120,300,50);
		addbranchdetailframe.add(addbranch).setBounds(220,180,150,40);
		addbranch.addActionListener(new ButtonListener(this));
		addbranchdetailframe.setVisible(true);
		addbranchdetailframe.setResizable(false);
		addbranchdetailframe.setSize(600,300);
		addbranchdetailframe.setLocation(200,100);
		
	}
	public static void main(String aa[])
	{
		AddBranchDetailFrame b=new AddBranchDetailFrame();
	}
	
	
	

}
