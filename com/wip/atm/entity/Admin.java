package com.wipro.atm.entity;

import com.wipro.atm.dao.*;
import com.wipro.atm.entity.*;
import com.wipro.atm.ui.AddCustomerFrame;
import com.wipro.atm.ui.JshowCheckDetails;
import com.wipro.atm.ui.JshowCustomerDetails;
import com.wipro.atm.ui.ModifyCustomerFrame;
public class Admin {
	public void addCustomer(Customer cob) throws Exception
	{
         boolean success= new CustomerDao().createCustomer(cob);
         System.out.println(success);
	}
	public void showCustomerDetails(int cid) throws Exception
	{
		System.out.println("in admin cd");
		String details[]=new CustomerDao().findByCustomerId(cid);
		
		new JshowCustomerDetails(details);
	}
	public void editCustomerDetails(int cid) throws Exception
	{
		String details[]=new CustomerDao().findByCustomerId(cid);
	    ModifyCustomerFrame mcf=new ModifyCustomerFrame();
	    mcf.cusid.setText(details[10]);
	    mcf.fullname.setText(details[1]);
	    mcf.fathersname.setText(details[2]);
	    mcf.permanentaddress.setText(details[5]);
	    mcf.presentaddress.setText(details[6]);
	    mcf.pannumber.setText(details[7]);
	    mcf.mobnumber.setText(details[8]);
	    mcf.landline.setText(details[9]);
	    
	 
	}
	public void showCheckDetails() throws Exception
	{
		
	 String cdtls[][]=new CheckDao().getcheck();
	 new JshowCheckDetails(cdtls);
	 
	}
	public void verifyCheck(Check chob) throws Exception
	{
		System.out.println("ad chno="+chob.getCheckno());
		new CheckDao().approveCheck(chob.getCheckno());
	}
	public void addBranchDetails(Branch bch) throws Exception
	{
		new BranchDao().createBranch(bch);
	}
}
