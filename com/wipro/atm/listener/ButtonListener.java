package com.wipro.atm.listener;

import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.wipro.atm.ui.*;
import com.wipro.atm.util.Authentication;
import com.wipro.atm.util.Transaction;

import com.wipro.atm.dao.AccountDao;
import com.wipro.atm.dao.CustomerDao;
import com.wipro.atm.entity.Admin;
import com.wipro.atm.entity.Branch;
import com.wipro.atm.entity.Check;
import com.wipro.atm.entity.Customer;
import com.wipro.atm.entity.User;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.wipro.atm.listener.*;

public class ButtonListener extends BoxListener implements ActionListener {
	
	Login lob;
	AdminFrame afob;
	AddCustomerFrame acfob;
    ModifyCustomerFrame mcfob;
    CustomerFrame cf;
   static DepositCheckFrame dcf;
    FastCashFrame fcf;
    AddBranchDetailFrame abdf;
    //CreateUserFrame cufo;
    ChangePinFrame cpf;
    GenerateAccountStatementFrame  gasf;
    
    static int  lcustomercardid;
    static String lPIN;
	public ButtonListener(){}
	public ButtonListener(Login lob)
	{
		this.lob=lob;
			
	}
	public ButtonListener(AdminFrame afob)
	{
		this.afob=afob;
			
	}
	public ButtonListener(AddCustomerFrame acfob)
	{
		this.acfob=acfob;
			
	}
	public ButtonListener(ModifyCustomerFrame mcfob)
	{
		this.mcfob=mcfob;
			
	}
	
	public ButtonListener(CustomerFrame cf)
	{
		this.cf=cf;
			
	}
	public ButtonListener(DepositCheckFrame cf)
	{
		this.dcf=dcf;
			
	}
	public ButtonListener(AddBranchDetailFrame abdf)
	{
		this.abdf=abdf;
			
	}
	public ButtonListener(FastCashFrame fcf)
	{
		this.fcf=fcf;
			
	}
	public ButtonListener(ChangePinFrame cpf)
	{
		this.cpf=cpf;
			
	}
	public ButtonListener(GenerateAccountStatementFrame gasf)
	{
		this.gasf=gasf;
			
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		String s=ae.getActionCommand();
		
		
		if(s.equals("Mini Statement"))
		 {
			int cid;
			try {
				cid = new CustomerDao().findCustomerIdByCardNo(lcustomercardid);
				new Customer().generateMiniStatement(cid);
			} catch (Exception gmse) {System.out.println(gmse);gmse.printStackTrace();}
			
			
		}
		
		 else if(s.equals("LOGIN"))
		{
			String usernametf,passwordp;
			int  usernametf1;	
			usernametf=lob.useridtf.getText();
			System.out.println("usernametf="+usernametf);
			lcustomercardid=Integer.parseInt(usernametf);
			
			System.out.println(lcustomercardid);
			usernametf1=Integer.parseInt(usernametf);
			passwordp=lob.password.getText();
			lPIN=passwordp;
			System.out.println(passwordp);
		
			try
			{
				User uob=new User();
				uob.setUserid(usernametf1);
				uob.setPassword(passwordp);
				Authentication aob=new Authentication(); 
				String utype=aob.authenticate(uob);
				System.out.println(utype);
				if(utype.equals("admin"))
				{
					Object obj[]={"Admin","Customer","Cancel"};
					int si=JOptionPane.showOptionDialog(Login.login,"would you like to enter as ADMIN or CUSTOMER","verification",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,obj,obj[2]);
					System.out.println("si="+si);
					System.out.println("admin");
					if(si==0)
					{
					new AdminFrame();
					lob.login.dispose();
					}
					else if(si==1)
					{
						new CustomerFrame();
						lob.login.dispose();
					}
					else
					{
						
					}
				}
				else if (utype.equals("user"))
				{
					System.out.println("user");
					new CustomerFrame();
					lob.login.dispose();
				}
				
				else
				{
					System.out.println("not valid");
				}
				
			}catch(Exception lex){System.out.println(lex);}
			
		}
		else if(s.equals("Add Customer"))
		{
			System.out.println("in ac b");

			new AddCustomerFrame();
			afob.adminframe.dispose();
		}
		else if(s.equals("Add Branch"))
		{
			new AddBranchDetailFrame();
		}
		else if(s.equals("Add Branch:"))
		{
			System.out.println("hvh");
			Branch bch=new Branch();
			try
			{
			bch.setBranchid(Integer.parseInt(abdf.branchid.getText()));
			bch.setBranchname(abdf.branchname.getText());
			bch.setBranchaddress(abdf.branchaddress.getText());
			try {
				new Admin().addBranchDetails(bch);
			} catch (Exception abde) {abde.printStackTrace();}
			}catch(Exception nfe){JOptionPane.showMessageDialog(AddBranchDetailFrame.addbranchdetailframe,"Only integer values accepted!");}
		}
		else if(s.equals("Verify Check"))
		{
			System.out.println("in veri");
			Check chob=new Check();
			String s2=JOptionPane.showInputDialog(AdminFrame.adminframe, "Enter Checkno ");
			System.out.println("s2="+s2);
		    int chkno=Integer.parseInt(s2);
		    System.out.println("vc chkno="+chkno);
		    
		    chob.setCheckno(chkno);
			try {
				new Admin().verifyCheck(chob);
			} catch (Exception vche) {vche.printStackTrace();}
			
		}
		else if(s.equals("Show Customer Details"))
		{    
			
			int uid=new ShowCustomerUid().showCustomerUid();
			
			//String sc=JOptionPane.showInputDialog(AdminFrame.adminframe, "enter uid");
		    //int uid=Integer.parseInt(s);
			
			try {
				new Admin().showCustomerDetails(uid);
			} catch (Exception sce) {System.out.println(sce);
				// TODO Auto-generated catch block
				sce.printStackTrace();
			}
		}
		else if(s.equals("showbranchdetails"))
		{
			
		}
		
		else if(s.equals("Show Checks"))
		{
			try {
				new Admin().showCheckDetails();
			} catch (Exception scde) {scde.printStackTrace();}
		}
		
		else if(s.equals("Edit Customer"))
		{
			int uid=new ShowCustomerUid().showCustomerUid();
			try {
				new Admin().editCustomerDetails(uid);
			} catch (Exception sce) {System.out.println(sce);
				// TODO Auto-generated catch block
				sce.printStackTrace();
			}
			
			;
		}
		else if(s.equals("Create User"))
		{
			new CreateUserFrame();
		}
		
		else if(s.equals("Edit User"))
		{
			new ModifyUserFrame();
		}
		else if(s.equals("logout"))
		{
			
		}
		else if(s.equals("OK"))
		{
			System.out.println("in ok");
			Customer cob=new Customer();
			cob.setFullname(acfob.fullname.getText());
			cob.setFathersname(acfob.fathersname.getText());
			cob.setPannumber(acfob.pannumber.getText());
			cob.setMobnumber(Integer.parseInt(acfob.mobnumber.getText()));
			cob.setLandline(Integer.parseInt(acfob.landline.getText()));
			cob.setOpeningbalance(Integer.parseInt(acfob.openingbalance.getText()));
			cob.setPermanentaddress(acfob.permanentaddress.getText());
			cob.setPresentaddress(acfob.presentaddress.getText());;
			cob.setAccounttype(super.baccounttype);
			cob.setCheckbook(super.bcheckbook);
			cob.setGender(AddCustomerFrame.gendertype);
			cob.setDob(super.bday+"-"+super.bmonth+"-"+super.byear);
			
			Admin aob=new Admin();
			try {
				aob.addCustomer(cob);
			} catch (Exception aace) {
				// TODO Auto-generated catch block
				aace.printStackTrace();
			}
			
			
		}
		else if(s.equals("MODIFY"))
		{
			
			Customer cob=new Customer();
			cob.setCustomerid(Integer.parseInt(mcfob.cusid.getText()));
			cob.setFullname(mcfob.fullname.getText());
			cob.setFathersname(mcfob.fathersname.getText());
			cob.setPannumber(mcfob.pannumber.getText());
			cob.setMobnumber(Integer.parseInt(mcfob.mobnumber.getText()));
			cob.setLandline(Integer.parseInt(mcfob.landline.getText()));
			cob.setOpeningbalance(Integer.parseInt(mcfob.openingbalance.getText()));
			cob.setPermanentaddress(mcfob.permanentaddress.getText());
			cob.setPresentaddress(mcfob.presentaddress.getText());;
			cob.setAccounttype(super.baccounttype);
			cob.setCheckbook(super.bcheckbook);
			cob.setGender(AddCustomerFrame.gendertype);
			cob.setDob(super.bday+"-"+super.bmonth+"-"+super.byear);
			
			
			try {
				CustomerDao cdob=new CustomerDao();
				cdob.modifyCustomer(cob);
			} catch (Exception aace) {
				// TODO Auto-generated catch block
				aace.printStackTrace();
			}
			
			
			
		}
		else if(s.equals("Change Pin"))
		{
			
		}
		else if(s.equals("Deposit Check"))
		{
			dcf=new DepositCheckFrame();
		}
		else if(s.equals("Deposit"))
		{
			System.out.println("lcustomercardid="+lcustomercardid);
			int custoid=0;
			try {
				custoid=new CustomerDao().findCustomerIdByCardNo(lcustomercardid);
				System.out.println("in deposit cid="+custoid);
			} catch (Exception dce) {dce.printStackTrace();}
			Check ck=new Check();
			
			ck.setCustomerid(custoid);
			
			ck.setCheckamount(Integer.parseInt(dcf.checkamount.getText()));
			
			ck.setCheckno(Integer.parseInt(dcf.checkno.getText()));
			ck.setBranchidofcheck(Integer.parseInt(dcf.checkbranchid.getText()));
			ck.setCheckissuedate(((JTextComponent) dcf.dateofcheckissue).getText());
			try {
				new Customer().depoditCheckByCash(ck);
			} catch (Exception dce) {dce.printStackTrace();}
		}
		else if(s.equals("Withdraw"))
		{

			Object obj[]={"Yes","No","exit"};
			int si=JOptionPane.showOptionDialog(Login.login,"would you like for Fastcash or GetCash,Yes for Fastcash,No for Getcash","verification",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,obj,obj[2]);
			if(si==0)
			{
				new FastCashFrame();
			}
			else if(si==1)
			{
				 Transaction tob= new Transaction();
				String sc=JOptionPane.showInputDialog(CustomerFrame.customerframe, "enter amount");
			    int amount=Integer.parseInt(sc);
			   tob.setAmount(amount);
			   try {
				tob.setCustomerid(new CustomerDao().findCustomerIdByCardNo(lcustomercardid));
			        } catch (Exception scie) {System.out.println(scie);scie.printStackTrace();}
				// TODO Auto-generated catch block
			         
			   try {
				   System.out.println("iiiiiin");
				new Customer().withdrawcash(tob); } catch (Exception e) {System.out.println(e);}
			  
			}
			else
			{
			
			}
			
		}
		else if(s.equals("Enter"))
		{

			 Transaction tob= new Transaction();
			
		    int amount=Integer.parseInt(BoxListener.enterfastcash);
		   tob.setAmount(amount);
		   try {
			tob.setCustomerid(new CustomerDao().findCustomerIdByCardNo(lcustomercardid));
		        } catch (Exception scie) {System.out.println(scie);scie.printStackTrace();}
			
		         
		   try {
			new Customer().withdrawcash(tob);} catch (Exception e) {}
		  }
		
		else if(s.equals("View Balance"))
		{
			try {
				
				int cid=new CustomerDao().findCustomerIdByCardNo(lcustomercardid);
				new Customer().viewbalance(cid);
				
			} catch (Exception vbe) {vbe.printStackTrace();}
		}	
		
		
		else if(s.equals("Change PIN"))
		{
			lPIN="12";
			System.out.println(cpf.currentpin.getText());
			String curpass=cpf.currentpin.getText();
			String newpass=cpf.newpin.getText();
			String confpass=cpf.confirm.getText();
			System.out.println(curpass+newpass+confpass);
			if(lPIN.equals(cpf.currentpin.getText()))
			{
				if(newpass.equals(confpass))
				{
					try {
						new User().changePassword(lcustomercardid,curpass,newpass);
					} catch (Exception cpe){cpe.printStackTrace();}
				}
				 else
				 {
					 System.out.println("new password  and confirm password doesnot match");
				 }
			}
			else
			{
				System.out.println("current password is incurrect");
			}
			
		}
		else if(s.equals("Get Account Statement"))
		{
		new GenerateAccountStatementFrame();	
		}
		else if(s.equals("Generate"))
		{
			DateFormat dfmyneed = new SimpleDateFormat("dd-MM-yyyy");
			DateFormat dff = new SimpleDateFormat("dd-MM-yyyy");
			DateFormat dft = new SimpleDateFormat("dd-MM-yyyy");
			
			  Date today = gasf.pickertoday.getDate();
			  Date fromdate=gasf.pickerfrom.getDate();
			  Date todate=gasf.pickerto.getDate();
			  
			    String tday=dfmyneed.format(today);
				String frmdate = dff.format(fromdate);
				String tdate = dft.format(todate);
				
				int tdy=Integer.parseInt(tday.substring(0,2)),tdymnth=Integer.parseInt(frmdate.substring(3,5)),tdyyr=Integer.parseInt(frmdate.substring(6,10));
				int fdt=Integer.parseInt(frmdate.substring(0,2)),fmnth=Integer.parseInt(frmdate.substring(3,5)),fyr=Integer.parseInt(frmdate.substring(6,10));
			    int tdt=Integer.parseInt(tdate.substring(0,2)),tmnth=Integer.parseInt(tdate.substring(3,5)),tyr=Integer.parseInt(tdate.substring(6,10));
			    
			    int cyd=tdyyr-tyr;
			    int cmd=tdymnth-tmnth;
			    int cdd=tdy-tdt;
			    
			    int dydf=tdt-fdt;
			    int mndf=tmnth-fmnth;
			    int yrdf=tyr-fyr;
			    
			    
			    if((cyd>0))
			    {
			    	if((yrdf>0))
				    {
				    	System.out.println("ok if year");
				    }
				    else if((yrdf==0) && (mndf>0))
				    {
				    	System.out.println("ok e i 1");
				    }
				    else if((yrdf==0) && (mndf==0) && dydf>=0)
				    {
				    	System.out.println("ok e i 2");
				    }
				    else 
				    {
				    System.out.println("wrong");	
				    }
			    }
			    else if((cyd==0) && (cmd>0))
			    {
			    	if((yrdf>0))
				    {
				    	System.out.println("ok if year");
				    }
				    else if((yrdf==0) && (mndf>0))
				    {
				    	System.out.println("ok e i 1");
				    }
				    else if((yrdf==0) && (mndf==0) && dydf>=0)
				    {
				    	System.out.println("ok e i 2");
				    }
				    else 
				    {
				    System.out.println("wrong");	
				    }	
			    }
			    else if((cyd==0) && (cmd==0) && cdd>=0)
			    {
			    	if((yrdf>0))
				    {
				    	System.out.println("ok if year");
				    }
				    else if((yrdf==0) && (mndf>0))
				    {
				    	System.out.println("ok e i 1");
				    }
				    else if((yrdf==0) && (mndf==0) && dydf>=0)
				    {
				    	System.out.println("ok e i 2");
				    }
				    else 
				    {
				    System.out.println("wrong");	
				    }
			    }
			    else 
			    {
			    System.out.println("to date canbe future");
			    }
			    
			    
			    
			    
			    
			    
			    	
				
			 
		}
		
	}
	
		
	
	
}
