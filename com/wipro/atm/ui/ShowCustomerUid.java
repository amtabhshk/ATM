package com.wipro.atm.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowCustomerUid {
	JFrame uidf;
	
	public int showCustomerUid(){
		uidf=new JFrame();
		uidf.setLayout(null);
	    uidf.setVisible(true);
	    uidf.setSize(100,100);
		String s=JOptionPane.showInputDialog(uidf, "enter uid");
	    int i=Integer.parseInt(s);
		return i;
	}

}
