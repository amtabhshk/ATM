package com.wipro.atm.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import com.wipro.atm.ui.AddCustomerFrame;
import com.wipro.atm.ui.CreateUserFrame;
import com.wipro.atm.ui.FastCashFrame;
import com.wipro.atm.ui.ModifyCustomerFrame;

public class BoxListener  implements ItemListener{
public static String byear,bmonth,bday,baccounttype,bcheckbook,enterfastcash,busertype;
	AddCustomerFrame acfob;
	ModifyCustomerFrame mcfob;
	FastCashFrame fcfob;
	CreateUserFrame cfob;
	public BoxListener(){}
	public BoxListener(AddCustomerFrame acfob)
	{
		this.acfob=acfob;
			
	}
	public BoxListener(ModifyCustomerFrame mcfob)
	{
		this.mcfob=mcfob;
			
	}
	public BoxListener(FastCashFrame fcfob)
	{
		this.fcfob=fcfob;
			
	}
	public BoxListener(CreateUserFrame cfob)
	{
		this.cfob=cfob;
			
	}
	@Override
	public void itemStateChanged(ItemEvent isc) {
		// TODO Auto-generated method stub
		//String soi=isc.getActionCommand();
		/*byear=(String) acfob.year.getSelectedItem();
		bmonth=(String) acfob.month.getSelectedItem();
		 bday=(String) acfob.day.getSelectedItem();*/
		 //baccounttype= acfob.accounttype.getItem();
		
		//bcheckbook=(String)  acfob.checkbook.getSelectedItem();
		//System.out.println(baccounttype);
		//System.out.println(bcheckbook);
		// System.out.println(baccounttype+bcheckbook);
		 //enterfastcash=(String) fcfob.enfastcash.getSelectedItem();
		 
		 //System.out.println( enterfastcash);
		//System.out.println(acfob.picker.isShowing());
		busertype=(String)cfob.usertype.getSelectedItem();
		System.out.println(busertype);
	}

}
