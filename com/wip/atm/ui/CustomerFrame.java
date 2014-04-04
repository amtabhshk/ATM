package com.wipro.atm.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CustomerFrame {
JButton changepin,cdepositcheck,viewbalance,withdrawcash,ministatement,clogout;
public static JFrame customerframe;

    public CustomerFrame() {
		// TODO Auto-generated constructor stub
    	customerframe=new JFrame();
    	customerframe.setTitle("Customer");
    	changepin=new JButton("Change Pin");
    	cdepositcheck=new JButton("Deposit Check");
    	withdrawcash=new JButton("Withdraw");
    	viewbalance=new JButton("View Balance");
    	ministatement=new JButton("Mni Statement");
    	clogout=new JButton("Logout");
    	customerframe.setLayout(null);
    	customerframe.add(changepin).setBounds(100, 50, 120, 30);
    	customerframe.add(cdepositcheck).setBounds(100,100,120,30);
    	customerframe.add(withdrawcash).setBounds(100,150,120,30);
    	customerframe.add(viewbalance).setBounds(250, 50, 120,30);
    	customerframe.add(ministatement).setBounds(250,100,120,30);
    	customerframe.add(clogout).setBounds(250, 150,120,30);
    	customerframe.setVisible(true);
    	customerframe.setSize(480,320);
    	customerframe.setLocation(200,100);
	}
    public static void main(String aa[])
    {
    	CustomerFrame cf=new CustomerFrame();
    }
}
