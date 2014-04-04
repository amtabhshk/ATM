package com.wipro.atm.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jdesktop.swingx.JXDatePicker;

import com.wipro.atm.listener.ButtonListener;

public class GenerateAccountStatementFrame {
	
	static JFrame generateaccountstatementframe;
	JComboBox selectcustomerid;
	JLabel fromdatel,todatel;
	JButton generate;
	public JXDatePicker pickerfrom,pickerto,pickertoday;
	
	public GenerateAccountStatementFrame() {
      
		generateaccountstatementframe=new JFrame();
		generateaccountstatementframe.setTitle("Generate Account Statement");
		selectcustomerid=new JComboBox();
		selectcustomerid.addItem("select Customer ID");
		fromdatel=new JLabel("From Date");
		todatel=new JLabel("To Date");
        generate=new JButton("Generate");
        
        generateaccountstatementframe.setLayout(null);
        
        pickerfrom = new JXDatePicker();
        pickerfrom.setDate(Calendar.getInstance().getTime());
        pickerfrom.setFormats(new SimpleDateFormat("dd-MMM-yyyy"));
       
        
        pickerto = new JXDatePicker();
        pickerto.setDate(Calendar.getInstance().getTime());
        pickerto.setFormats(new SimpleDateFormat("dd-MMM-yyyy"));
        
        pickertoday = new JXDatePicker();
        pickertoday.setDate(Calendar.getInstance().getTime());
        pickertoday.setFormats(new SimpleDateFormat("dd-MMM-yyyy"));
        
        generateaccountstatementframe.add(selectcustomerid).setBounds(200,40,200,30);
        generateaccountstatementframe.add(fromdatel).setBounds(80,90,100,30);
        generateaccountstatementframe.add(pickerfrom).setBounds(150,90,130,30);
        generateaccountstatementframe.add(todatel).setBounds(300,90,100,30);
        generateaccountstatementframe.add(pickerto).setBounds(350,90,130,30);
        generateaccountstatementframe.add(generate).setBounds(250,150,100,30);
        
        generate.addActionListener(new ButtonListener(this));
        
        generateaccountstatementframe.setVisible(true);
        generateaccountstatementframe.setSize(600,700);
        generateaccountstatementframe.setLocation(250,20);
        generateaccountstatementframe.setResizable(false);
		

   }
	public static void main(String aa[])
	{
		GenerateAccountStatementFrame gasf=new GenerateAccountStatementFrame();
	}
}