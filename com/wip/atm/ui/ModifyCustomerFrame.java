package com.wipro.atm.ui;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.wipro.atm.listener.BoxListener;
import com.wipro.atm.listener.ButtonListener;

public class ModifyCustomerFrame {
	
	JFrame modifycustomerframe;
	public JTextField fullname;
	public JTextField cusid;
	public JTextField fathersname;
	public JTextField pannumber;
	public JTextField mobnumber,landline,openingbalance,withdrawalamount;
	public JTextArea permanentaddress,presentaddress;
    public JCheckBox checkbook;
    public ButtonGroup gender;
    public JRadioButton male;
	public JRadioButton female;
	public JComboBox day;
	public JComboBox month;
	public JComboBox year;
	public JComboBox accounttype;
	JLabel fullnamel,fathersnamel,pannumberl,accounttypel,mobnumberl,landlinel,openingbalancel,withdrawalamountl,permanentaddressl,presentaddressl,
	              checkbookl,genderl,dobl;
	JButton modify;
	JPanel p,p2;
	public static String gendertype="";
	public ModifyCustomerFrame()
	{
		p=new JPanel();
		p2=new JPanel();
		
		modifycustomerframe=new JFrame();
		modify=new JButton("MODIFY");
		cusid=new JTextField(20);
		fullname=new JTextField(150);
		fathersname=new JTextField(150);
		pannumber=new JTextField(150);
		mobnumber=new JTextField(150);
		landline=new JTextField(150);
		openingbalance=new JTextField(150);
		withdrawalamount=new JTextField(150);
		permanentaddress=new JTextArea(150,10);
		presentaddress=new JTextArea(150,10);
		checkbook=new JCheckBox();
		male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		gender=new ButtonGroup();
		gender.add(male);
		gender.add(female);
		fullnamel=new JLabel("Full Name");
		fathersnamel=new JLabel("Father Name");
		pannumberl=new JLabel("PAN Number");
		accounttypel=new JLabel("Account Type");
		mobnumberl=new JLabel("Mobile Number");
		landlinel=new JLabel("Landline Number");
		openingbalancel=new JLabel("Opening Balance");
		day=new JComboBox();
		
		for(int i=0;i<31;i++)
		{
			day.addItem(""+(i+1));
		}
		month=new JComboBox();
				for(int i=0;i<12;i++)
				{
					month.addItem(""+(i+1));
				}
				
		year=new JComboBox();
		for(int i=1930;i<2012;i++)
		{
			year.addItem(""+(i+1));
		}
		
		accounttype=new JComboBox();
		accounttype.addItem("");
		accounttype.addItem("Current");
		accounttype.addItem("Savings");
		
		permanentaddressl=new JLabel("Permanent Address");
		presentaddressl=new JLabel("Present Address");
		checkbookl=new JLabel("Check Book");
		genderl=new JLabel("Gender");
		dobl=new JLabel("DOB");
		
		p.add(year);
		p.add(month);
		p.add(day);
		p.setLayout(new FlowLayout());
		p2.add(male);
		p2.add(female);
		p2.setLayout(new FlowLayout());
		modifycustomerframe.add(cusid);
		modifycustomerframe.add(fullnamel);
		modifycustomerframe.add(fullname);
		modifycustomerframe.add(fathersnamel);
		modifycustomerframe.add(fathersname);
		modifycustomerframe.add(genderl);
		modifycustomerframe.add(p2);
		
		modifycustomerframe.add(dobl);
		modifycustomerframe.add(p);
		
		modifycustomerframe.add(permanentaddressl);
		modifycustomerframe.add(permanentaddress);
		modifycustomerframe.add(presentaddressl);
		modifycustomerframe.add(presentaddress);
		modifycustomerframe.add(pannumberl);
		modifycustomerframe.add(pannumber);
		modifycustomerframe.add(mobnumberl);
		modifycustomerframe.add(mobnumber);
		modifycustomerframe.add(landlinel);
		modifycustomerframe.add(landline);
		modifycustomerframe.add(accounttypel);
		modifycustomerframe.add(accounttype);
		modifycustomerframe.add(checkbookl);
		modifycustomerframe.add(checkbook);
		modifycustomerframe.add(openingbalancel);
		modifycustomerframe.add(openingbalance);
		modifycustomerframe.add(modify);
		modifycustomerframe.setLayout(new GridLayout(15,2));
		modifycustomerframe.setVisible(true);
		modifycustomerframe.setSize(700,700);
		
		modify.addActionListener(new ButtonListener(this));
		day.addItemListener(new BoxListener(this));
		month.addItemListener(new BoxListener(this));
		year.addItemListener(new BoxListener(this));
		male.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent mae){gendertype=mae.getActionCommand();
		System.out.println(gendertype);}});
		female.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent fae){gendertype=fae.getActionCommand();
		System.out.println(gendertype);}});
		
		female.addItemListener(new BoxListener(this));
		checkbook.addItemListener(new BoxListener(this));
		accounttype.addItemListener(new BoxListener(this));
	}   
}

