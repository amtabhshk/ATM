package com.wipro.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.atm.entity.Customer;
import com.wipro.atm.listener.BoxListener;
import com.wipro.atm.ui.AddCustomerFrame;
import com.wipro.atm.ui.AdminFrame;
import com.wipro.atm.util.DbUtil;

public class CustomerDao {
	Connection conn;
	ResultSet rs,rsgetcustid;
	PreparedStatement createcustomerpst,findbycustomeridpst,deletecustomerpst,modifycustomerpst
	                ,findcusnobycardno;
	 public CustomerDao() throws Exception
     {
   	  DbUtil du=new DbUtil();
   	  this.conn=du.createDbCon();
     }
     public boolean createCustomer(Customer cob) throws Exception
     {
    	 
    	 
    	 createcustomerpst=conn.prepareStatement("insert into atm_customer_details_tb values(cardno_seq.nextval,?,?,sysdate,?,?,?,?,?,?,customerid_seq.nextval,pin_seq.nextval,?,?,accountno_seq.nextval,'cok',branchid_seq.nextval)");
    	 //createcustomerpst.setLong(1,cob.getCardNo());
    	 createcustomerpst.setString(1,cob.getFullname());
    	 System.out.println(cob.getFullname());
    	 createcustomerpst.setString(2,cob.getFathersname());String sys="sysdate";
    	 System.out.println(cob.getFathersname());
    	// createcustomerpst.setString(3,sys);
    	 createcustomerpst.setString(3,cob.getGender());
    	 System.out.println(cob.getGender());
    	 createcustomerpst.setString(4,cob.getPermanentaddress());
    	 System.out.println(cob.getPermanentaddress());
    	 createcustomerpst.setString(5,cob.getPresentaddress());
    	 System.out.println(cob.getPresentaddress());
    	 createcustomerpst.setString(6,cob.getPannumber());
    	 System.out.println(cob.getPannumber());
    	 createcustomerpst.setInt(7,cob.getMobnumber());
    	 System.out.println(cob.getMobnumber());
    	 createcustomerpst.setInt(8,cob.getLandline());
    	 System.out.println(cob.getLandline());
    	 //createcustomerpst.setInt(11,cob.getCustomerid());
    	 //createcustomerpst.setInt(12,cob.getPin());
    	 createcustomerpst.setString(9,cob.getAccounttype());
    	 System.out.println(cob.getAccounttype());
    	 createcustomerpst.setInt(10,cob.getOpeningbalance());
    	 System.out.println(cob.getOpeningbalance());
    	 //createcustomerpst.setLong(15,cob.getAccountnumber());
    	 //createcustomerpst.setString(16,cob.getCheckbook());
    	 //createcustomerpst.setInt(17,cob.getBranchid());
    	 createcustomerpst.executeUpdate();
    	 
    	 PreparedStatement pscu=conn.prepareStatement("select cardno,password from atm_customer_details_tb where fullname=(?) and mobnumber=(?)");
    	 pscu.setString(1,cob.getFullname());
    	 pscu.setInt(2,cob.getMobnumber());
    	 ResultSet rs=pscu.executeQuery();
    	 rs.next();
    	 String cardno=rs.getString(1);
    	 String password=rs.getString(2);
    	 
    	 PreparedStatement pscu2=conn.prepareStatement("insert into atm_user_tb values(?,?,'user','N')");
    	 pscu2.setString(1,cardno);
    	 pscu2.setString(2,password);
    	 pscu2.executeUpdate();
    	 JOptionPane.showMessageDialog(AdminFrame.adminframe,"New UserId = "+cardno+ "\n New Password = "+password);
    	 
    	 return true;
    	 
     }
     public String[] findByCustomerId(int cid) throws Exception
     {
    	 String[] customerdetails=new String[17];
    	 
    	 findbycustomeridpst=conn.prepareStatement("select * from atm_customer_details_tb where customerid="+cid);
    	 rs=findbycustomeridpst.executeQuery();
    	 while(rs.next())
    	 {
    		 for(int i=0;i<17;i++)
    		 {
    		customerdetails[i]=rs.getString((i+1));
    		//System.out.println(customerdetails[i]);
    		 }
    		
    	 }
    	 return customerdetails;
    		
    	 
     }
     public boolean deleteCustomer(int customerid) throws Exception
     {
    	 deletecustomerpst=conn.prepareStatement("delete from atm_customer_details_tb where customerid="+customerid);
    	 return true;
     }
     public boolean modifyCustomer(Customer cob) throws Exception
     {
    
    	 modifycustomerpst=conn.prepareStatement("update atm_customer_details_tb set full_name=(?),father_name=(?),DOB=(?),gender=(?),");
    	 //createcustomerpst.setLong(1,cob.getCardNo());
    	 modifycustomerpst.setString(1,cob.getFullname());
    	 System.out.println(cob.getFullname());
    	 modifycustomerpst.setString(2,cob.getFathersname());String sys="sysdate";
    	 System.out.println(cob.getFathersname());
    	// createcustomerpst.setString(3,sys);
    	 modifycustomerpst.setString(3,cob.getGender());
    	 System.out.println(cob.getGender());
    	 modifycustomerpst.setString(4,cob.getPermanentaddress());
    	 System.out.println(cob.getPermanentaddress());
    	 modifycustomerpst.setString(5,cob.getPresentaddress());
    	 System.out.println(cob.getPresentaddress());
    	 modifycustomerpst.setString(6,cob.getPannumber());
    	 System.out.println(cob.getPannumber());
    	 modifycustomerpst.setInt(7,cob.getMobnumber());
    	 System.out.println(cob.getMobnumber());
    	 modifycustomerpst.setInt(8,cob.getLandline());
    	 System.out.println(cob.getLandline());
    	 //createcustomerpst.setInt(11,cob.getCustomerid());
    	 //createcustomerpst.setInt(12,cob.getPin());
    	 modifycustomerpst.setString(9,cob.getAccounttype());
    	 System.out.println(cob.getAccounttype());
    	 modifycustomerpst.setInt(10,cob.getOpeningbalance());
    	 System.out.println(cob.getOpeningbalance());
    	 //createcustomerpst.setLong(15,cob.getAccountnumber());
    	 //createcustomerpst.setString(16,cob.getCheckbook());
    	 //createcustomerpst.setInt(17,cob.getBranchid());
    	 modifycustomerpst.executeUpdate();
    	 
    	 return true;
    	
     }
     public int findCustomerIdByCardNo(int cno) throws Exception
     {
    	 findcusnobycardno=conn.prepareStatement("select customerid from atm_customer_details_tb where cardno="+cno);
    	 rs=findcusnobycardno.executeQuery();
    	 rs.next();
    	 //System.out.println("custid="+rs.getInt(1));
    	 return rs.getInt(1);
    	 
     }
}
