package com.wipro.atm.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DeleteCustomerFrame {
	
	JComboBox deletecustomerid;
	JButton confirmdelete;
	JFrame deletecustomerframe;
	
	public DeleteCustomerFrame() {
		
		deletecustomerframe=new JFrame();
		deletecustomerframe.setLayout(null);
		deletecustomerframe.setTitle("Delete Customer");
		deletecustomerid=new JComboBox();
		deletecustomerid.addItem("Select Customer ID");
		confirmdelete=new JButton("Confirm Delete");
		deletecustomerframe.add(deletecustomerid).setBounds(130,40,150,30);
		deletecustomerframe.add(confirmdelete).setBounds(340,40,150,30);
		
		
		
		deletecustomerframe.setVisible(true);
		deletecustomerframe.setSize(600,400);
		deletecustomerframe.setLocation(250,50);
		deletecustomerframe.setResizable(false);
	
	
	}
	
	public static void main(String aa[])
	{
		DeleteCustomerFrame dcf=new DeleteCustomerFrame();
	}

}
