package com.wipro.atm.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import org.jdesktop.swingx.JXDatePicker;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import com.wipro.atm.listener.BoxListener;
import com.wipro.atm.listener.ButtonListener;



public class AddCustomerFrame {
	
	public static JFrame addcustomerframe;
	public JTextField fullname;
	public JTextField fathersname;
	public JTextField pannumber;
	public JTextField mobnumber,landline,openingbalance,withdrawalamount,datetf;
	public JTextArea permanentaddress,presentaddress;
   
    public ButtonGroup gender;
    public JRadioButton male;
	public JRadioButton female;
	
	public JComboBox accounttype,checkbook;
	JLabel fullnamel,fathersnamel,pannumberl,accounttypel,mobnumberl,landlinel,openingbalancel,withdrawalamountl,permanentaddressl,presentaddressl,
	              checkbookl,genderl,dobl,l;
	JButton ok;
	public JXDatePicker picker;
	JPanel p,p2;
	public static String gendertype="";
	public AddCustomerFrame()
	{
		p=new JPanel();
		p2=new JPanel();

        picker = new JXDatePicker();
       picker.setDate(Calendar.getInstance().getTime());
       picker.setFormats(new SimpleDateFormat("dd-MMM-yyyy"));
       
		addcustomerframe=new JFrame();
		addcustomerframe.setTitle("Add customer ");
		ok=new JButton("OK");
		datetf=new JTextField(40);
		fullname=new JTextField(150);
		fathersname=new JTextField(150);
		pannumber=new JTextField(150);
		mobnumber=new JTextField(150);
		landline=new JTextField(150);
		openingbalance=new JTextField(150);
		withdrawalamount=new JTextField(150);
		permanentaddress=new JTextArea(350,100);
		presentaddress=new JTextArea(350,100);
		checkbook=new JComboBox();
		checkbook.addItem("Yes");
		checkbook.addItem("No");
		male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		gender=new ButtonGroup();
		gender.add(male);
		gender.add(female);
		//l=new JLabel("----------------------------------------------------");
		//l.setBackground(Color.RED);
		fullnamel=new JLabel("Full Name");
		fathersnamel=new JLabel("Father Name");
		pannumberl=new JLabel("PAN Number");
		accounttypel=new JLabel("Account Type");
		mobnumberl=new JLabel("Mobile Number");
		landlinel=new JLabel("Landline Number");
		openingbalancel=new JLabel("Opening Balance");
		
		
		accounttype=new JComboBox();
		accounttype.addItem("Savings");
		accounttype.addItem("Current");
		
		
		permanentaddressl=new JLabel("Permanent Address");
		presentaddressl=new JLabel("Present Address");
		checkbookl=new JLabel("Check Book");
		genderl=new JLabel("Gender");
		dobl=new JLabel("DOB");
		
		
		p.add(picker);
		
		
		p2.add(male);
		p2.add(female);
		p2.setLayout(new FlowLayout());
		addcustomerframe.setLayout(null);
		addcustomerframe.add(fullnamel).setBounds(50,40,100,30);
		addcustomerframe.add(fullname).setBounds(210,40,350,30);
		addcustomerframe.add(fathersnamel).setBounds(50,80,100,30);
		addcustomerframe.add(fathersname).setBounds(210,80,350,30);
		addcustomerframe.add(genderl).setBounds(50,120,100,30);
		addcustomerframe.add(p2).setBounds(210,120,350,30);
		
		addcustomerframe.add(dobl).setBounds(50,160,100,30);
		addcustomerframe.add(p).setBounds(210,160,350,30);
		
		addcustomerframe.add(permanentaddressl).setBounds(50,200,100,30);
		addcustomerframe.add(permanentaddress).setBounds(210,200,350,100);
		//addcustomerframe.add(l).setBounds(210,201,350,30);
		addcustomerframe.add(presentaddressl).setBounds(50,310,100,30);
		addcustomerframe.add(presentaddress).setBounds(210,310,350,100);
		addcustomerframe.add(pannumberl).setBounds(50,420,100,30);
		addcustomerframe.add(pannumber).setBounds(210,420,350,30);
		addcustomerframe.add(mobnumberl).setBounds(50,460,100,30);
		addcustomerframe.add(mobnumber).setBounds(210,460,350,30);
		addcustomerframe.add(landlinel).setBounds(50,500,100,30);
		addcustomerframe.add(landline).setBounds(210,500,350,30);
		addcustomerframe.add(accounttypel).setBounds(50,540,100,30);
		addcustomerframe.add(accounttype).setBounds(210,540,350,30);
		addcustomerframe.add(checkbookl).setBounds(50,580,100,30);
		addcustomerframe.add(checkbook).setBounds(210,580,350,30);
		addcustomerframe.add(openingbalancel).setBounds(50,620,100,30);
		addcustomerframe.add(openingbalance).setBounds(210,620,350,30);
		addcustomerframe.add(ok).setBounds(320,680,100,30);
		
		addcustomerframe.setVisible(true);
		addcustomerframe.setSize(700,755);
		addcustomerframe.setResizable(false);
		
		ok.addActionListener(new ButtonListener(this));	
		accounttype.addItemListener(new BoxListener(this));
		picker.addActionListener(new ButtonListener(this));
		checkbook.addItemListener(new BoxListener(this));
		male.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent mae){gendertype=mae.getActionCommand();
		System.out.println(gendertype);}});
		female.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent fae){gendertype=fae.getActionCommand();
		System.out.println(gendertype);}});
		
		
		
		
	}   
	public static void main(String aa[])
	{
		AddCustomerFrame a=new AddCustomerFrame();
	}
}
