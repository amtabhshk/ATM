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



public class JgenerateMiniStatementFrame extends JFrame {
	
 
     
	JTable mytab1;
	
	//String details[]=new String[17];
	Vector columnNames=new Vector();
	     String  columnNames1[][] = {{"Date"},{"Deposit"},{"Withdraw"},{"Balance"}};
		Vector rowNames=new Vector();
		public JgenerateMiniStatementFrame(String [][]details) throws Exception
	       {
			int k=0;
			for(int i=0;i<4;i++)
			{
				columnNames.addElement(columnNames1[i][0]);
			}
			
			for(int j=0;j<10;j++)
			{
				Vector row=new Vector();
				for(int l=0;l<4;l++)
				{
					row.addElement(details[j][l]);
				}
				rowNames.addElement(row);
				
				
				
				
			}
			
			
				mytab1=new JTable( rowNames, columnNames);
				
				JScrollPane js=new JScrollPane(mytab1);
				add(js);
				setVisible(true);
				setLayout(new FlowLayout());
				setSize(500,500);
				
	
}}

