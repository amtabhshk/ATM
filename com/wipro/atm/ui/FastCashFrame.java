package com.wipro.atm.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FastCashFrame {
public JComboBox enfastcash;
JButton enter;

JFrame fastcashframe;
public FastCashFrame() {
	// TODO Auto-generated constructor stub
enfastcash =new JComboBox();
enfastcash.addItem("Select Cash");
for(int i=500;i<=15000;i=i+500)
{
	enfastcash.addItem(""+(i));
}
enter=new JButton("Enter");

fastcashframe=new JFrame();
fastcashframe.setTitle("Select Fastcash");
fastcashframe.add(enfastcash);
fastcashframe.add(enter);
fastcashframe.setLayout(new FlowLayout());
fastcashframe.setVisible(true);
fastcashframe.setSize(250, 70);
fastcashframe.setLocation(300, 100);
fastcashframe.setResizable(false);

}
public static void main(String aa[])
{
	FastCashFrame fc=new FastCashFrame();
}
}
