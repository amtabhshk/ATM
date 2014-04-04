package com.wipro.atm.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.atm.listener.ButtonListener;

public class ChangePinFrame {

	JLabel currentpinl,newpinl,confirmpinl;
	public JPasswordField currentpin;
	public JPasswordField newpin;
	public JPasswordField confirm;
	JButton changepinb;
	JFrame changepinframe;
	public ChangePinFrame() {
	
		changepinframe=new JFrame();
		changepinframe.setTitle("Chane PIN");
		currentpinl=new JLabel("Current PIN");
		newpinl=new JLabel("New PIN");
		confirmpinl=new JLabel("Confirm PIN");
		currentpin=new JPasswordField(40);
		newpin=new JPasswordField(40);
		confirm=new JPasswordField(40);
		changepinb=new JButton("Change PIN");
		
		changepinframe.setLayout(null);
		changepinframe.add(currentpinl).setBounds(40,30,100,30);
		changepinframe.add(currentpin).setBounds(140,30,200,30);
		changepinframe.add(newpinl).setBounds(40,70,100,30);
		changepinframe.add(newpin).setBounds(140,70,200,30);
		changepinframe.add(confirmpinl).setBounds(40,110,100,30);
		changepinframe.add(confirm).setBounds(140,110,200,30);
		changepinframe.add(changepinb).setBounds(180,160,100,30);
		changepinb.addActionListener(new ButtonListener(this));
		
		changepinframe.setVisible(true);
		changepinframe.setSize(400,300);
		changepinframe.setLocation(200,100);
		changepinframe.setResizable(false);
		
	}
	public static void main(String aa[])
	{
		ChangePinFrame cpf=new ChangePinFrame();
	}
}
