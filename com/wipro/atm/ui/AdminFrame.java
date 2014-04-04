package com.wipro.atm.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.wipro.atm.listener.ButtonListener;

public class AdminFrame {
	public  static JFrame adminframe;
	JButton addcustomer,editcustomerdetails,deletecustomerdetails,showcustomerdetails,addbranch,
	verifycheck,getstatement,
	showbranchdetails,showcheckdetails,edituser,logout;
	public AdminFrame()
	{
		adminframe=new JFrame();
		addcustomer=new JButton("Add Customer");
		addbranch=new JButton("Add Branch");
		verifycheck=new JButton("Verify Check");
		getstatement=new JButton("Get Account Statement");
		showcustomerdetails=new JButton("Show Customer Details");
		showbranchdetails=new JButton("Show Branchs");
		showcheckdetails=new JButton("Show Checks");
		deletecustomerdetails=new JButton("Delete Customer");
		editcustomerdetails=new JButton("Edit Customer");
		
		edituser=new JButton("Edit User");
		logout=new JButton("Logout");
		addcustomer.addActionListener(new ButtonListener(this));
		addbranch.addActionListener(new ButtonListener(this));
		verifycheck.addActionListener(new ButtonListener(this));
		getstatement.addActionListener(new ButtonListener(this));
		showcustomerdetails.addActionListener(new ButtonListener(this));
		showbranchdetails.addActionListener(new ButtonListener(this));
		showcheckdetails.addActionListener(new ButtonListener(this));
		deletecustomerdetails.addActionListener(new ButtonListener(this));
		editcustomerdetails.addActionListener(new ButtonListener(this));
		
		edituser.addActionListener(new ButtonListener(this));
		logout.addActionListener(new ButtonListener(this));
	    adminframe.setLayout(null);
	    adminframe.setVisible(true);
	    adminframe.setSize(430,400);
	    adminframe.setLocation(300,100);
	    adminframe.setTitle("Admin utility");
	    
	    
	    adminframe.add(addcustomer);
	    addcustomer.setBounds(40,40,150, 40);
	    
	    adminframe.add(editcustomerdetails);
	    editcustomerdetails.setBounds(40,90,150, 40);
		
	    
	    
	    adminframe.add(deletecustomerdetails);
	    deletecustomerdetails.setBounds(40,140,150, 40);
		
	    adminframe.add(showcustomerdetails);
	    showcustomerdetails.setBounds(40,190,150, 40);
	    
	    adminframe.add(addbranch);
	    addbranch.setBounds(40,240,150, 40);
		
	    
	    
	    adminframe.add(verifycheck);
	    verifycheck.setBounds(230,40,150, 40);
		
	    adminframe.add(getstatement);
	    getstatement.setBounds(230,90,150, 40);
	    
	    adminframe.add(showbranchdetails);
	    showbranchdetails.setBounds(230,140,150, 40);
	    
	    adminframe.add(showcheckdetails);
	    showcheckdetails.setBounds(230,190,150, 40);
		
	    adminframe.add(edituser);
	    edituser.setBounds(230,240,150, 40);
	    
	    adminframe.add(logout);
	    logout.setBounds(140,290,150, 40);
	    
		
	}
	public static void main(String aa[])
	{
	AdminFrame a=new AdminFrame();
	}

}
