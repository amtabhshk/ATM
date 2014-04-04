package com.wipro.atm.ui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class JshowCustomerDetails extends JFrame {
	

	
	JTable mytab;
	//String details[]=new String[17];
		String columnNames[] = { "Name", "Father Name", "DOB","Gender","Permnent add" ,"present addrs","pan","mob no","land line","customer id","pin","account type","opening balance","account number","check book","branch id"};
		String rowNames[][]=new String[1][17];
		public JshowCustomerDetails(String []details) throws Exception
	       {
			for(int i=0;i<17;i++)
			{
				rowNames[0][i]=details[i];
			}
				
				
			
				mytab=new JTable(rowNames,columnNames);
				//mytab.setBackground(Color.GRAY);
				//mytab.setForeground(Color.white);
		        //mytab.setAutoResizeMode(WIDTH);
				JScrollPane js=new JScrollPane(mytab);
				add(js);
				setVisible(true);
				setLayout(new FlowLayout());
				setSize(900,100);
				
	
}}






