package com.wipro.atm.ui;



import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ModifyBranchDetailFrame {
	JFrame modifybranchdetailframe;
	JTextField mbranchname,mbranchid;
	JTextArea mbranchaddress;
	JButton mmodifybranch; 
	JLabel mbranchnamel,mbranchidl,mbranchaddressl;
	
	ModifyBranchDetailFrame ()
	{
		modifybranchdetailframe=new JFrame();
		modifybranchdetailframe.setTitle("Modify Branch Details");
		mbranchname=new JTextField(40);
		mbranchaddress=new JTextArea(40,40);
		mbranchid=new JTextField(40);
		mmodifybranch= new  JButton("Modify Branch");
		mbranchnamel=new JLabel("Branch Name");
		mbranchidl=new JLabel("Branch Id");
		mbranchaddressl=new JLabel("Branch Address");
		modifybranchdetailframe.setLayout(null);
		modifybranchdetailframe.add(mbranchnamel).setBounds(40,40,200,30);
		modifybranchdetailframe.add(mbranchname).setBounds(150, 40,300,30);
		modifybranchdetailframe.add(mbranchidl).setBounds(40,80, 200,30);
	    modifybranchdetailframe.add(mbranchid).setBounds(150, 80, 300,30);
	    modifybranchdetailframe.add(mbranchaddressl).setBounds(40, 120,200,30);
	    modifybranchdetailframe.add(mbranchaddress).setBounds(150,120,300,50);
	    modifybranchdetailframe.add(mmodifybranch).setBounds(220,180,150,40);
	    modifybranchdetailframe.setVisible(true);
	    modifybranchdetailframe.setResizable(false);
	    modifybranchdetailframe.setSize(600,300);
	    modifybranchdetailframe.setLocation(200,100);
		
	}
	public static void main(String aa[])
	{
		ModifyBranchDetailFrame  b=new ModifyBranchDetailFrame ();
	}
	
	
	

}
