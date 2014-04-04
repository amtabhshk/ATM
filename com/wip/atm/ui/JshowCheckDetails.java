package com.wipro.atm.ui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class JshowCheckDetails extends JFrame {
	
 

	JTable mytab;
	String s[]=new String[8];
	String s1[]=new String[8],s2,s3;
	//String details[]=new String[17];
	Vector columnNames=new Vector();
	     String  columnNames1[][] = {{"Customer Id"},{"Customer Name"},{"Check No"},{"Check Amount"},{"Branch Id"},{"Status"},{"Deposit Date"},{"Date of chk issue"}};
		Vector rowNames=new Vector();
		public JshowCheckDetails(String [][]details) throws Exception
	       {
			int k=0;
			for(int i=0;i<8;i++)
			{
				columnNames.addElement(columnNames1[i][0]);
			}
			
			for(int j=0;j<20;j++)
			{
				Vector row=new Vector();
				for(int l=0;l<8;l++)
				{
					row.addElement(details[j][l]);
				}
				rowNames.addElement(row);
				
				
				
				
			}
			
			
				mytab=new JTable( rowNames, columnNames);
				
				JScrollPane js=new JScrollPane(mytab);
				add(js);
				setVisible(true);
				setLayout(new FlowLayout());
				setSize(500,500);
				
	
}}






