package com.wipro.atm.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class DepositCheckFrame {


	
		public static JFrame depositckeckframe;
		public JTextField checkno;
		public JTextField checkbranchid;
		public JTextField checkamount;
		
		JButton depositcheck; 
		JLabel checknol,checkbranchidl,checkamountl;
		public Object dateofcheckissue;
		
		public DepositCheckFrame ()
		{
			depositckeckframe=new JFrame();
			depositckeckframe.setTitle("Deposit Check Details");
			checkno=new JTextField(40);
			checkbranchid=new JTextField(40);
			checkamount=new JTextField(40);
			depositcheck= new  JButton("  Deposit Check");
			checknol=new JLabel("Check No:");
			checkbranchidl=new JLabel("Check Branch Id");
			checkamountl=new JLabel("Check Amount");
			depositckeckframe.setLayout(null);
			depositckeckframe.add(checknol).setBounds(40,40,200,30);
			depositckeckframe.add(checkno).setBounds(150, 40,300,30);
			depositckeckframe.add(checkbranchidl).setBounds(40,80, 200,30);
			depositckeckframe.add(checkbranchid).setBounds(150, 80, 300,30);
			depositckeckframe.add(checkamountl).setBounds(40, 120,200,30);
			depositckeckframe.add(checkamount).setBounds(150,120,300,30);
			depositckeckframe.add(depositcheck).setBounds(220,180,150,40);
			depositckeckframe.setVisible(true);
			depositckeckframe.setResizable(false);
			depositckeckframe.setSize(600,300);
			depositckeckframe.setLocation(200,100);
			
		}
		public static void main(String aa[])
		{
			DepositCheckFrame b=new DepositCheckFrame();
		}
}
		
		
		

	
