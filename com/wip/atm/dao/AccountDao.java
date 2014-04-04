package com.wipro.atm.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.atm.entity.Account;
import com.wipro.atm.entity.Customer;
import com.wipro.atm.listener.BoxListener;
import com.wipro.atm.ui.AddCustomerFrame;
import com.wipro.atm.ui.AdminFrame;
import com.wipro.atm.util.DbUtil;
import com.wipro.atm.util.Transaction;

public class AccountDao {
	Connection conn;
	ResultSet rsgb,rsadcr,rsgmins;
	PreparedStatement ps,psgb,psadcr,psgmins;
	 public AccountDao() throws Exception
	 {
		 DbUtil du=new DbUtil();
	   	  this.conn=du.createDbCon();
	 }
	 public void removeCredit(Transaction tob) throws Exception
	 {
		 System.out.println("in remv");
		 long currentbalance=getBalance(tob.getCustomerid());
		 String[] cusdetail=new CustomerDao().findByCustomerId(tob.getCustomerid());
		 ps=conn.prepareStatement("insert into atm_account_details_tb values (?,?,0,sysdate,?,?)");
		 ps.setInt(1,tob.getCustomerid());
		 ps.setString(2,cusdetail[1]);
		 ps.setInt(3,tob.getAmount());
		 ps.setLong(4,(currentbalance-(long)tob.getAmount()));
		 ps.executeUpdate();
		 		System.out.println("in re ex");
	 }
	 public long getBalance(int cid) throws Exception
	 {
		 System.out.println("in getb");
		 long bal=0;
		 psgb=conn.prepareStatement("select balance from atm_account_details_tb where customerid="+cid);
		rsgb=psgb.executeQuery();
		while(rsgb.next())
		{
			bal=rsgb.getInt(1);
			System.out.println("in getbal="+rsgb.getInt(1));
		}
		return bal;
	 }
	 public void addCredit(Transaction tob) throws Exception
	 {
		 long currentbalance=getBalance(tob.getCustomerid());
		 String[] cusdetail=new CustomerDao().findByCustomerId(tob.getCustomerid());
		 
		 for(int i=0;i<17;i++)
		 {
		
		System.out.println(""+(i)+"="+cusdetail[i]);
		 }
		 
		 psadcr=conn.prepareStatement("insert into atm_account_details_tb values (?,?,?,sysdate,0,?)");
		 psadcr.setInt(1,tob.getCustomerid());
		 psadcr.setString(2,cusdetail[1]);
		 psadcr.setInt(3,tob.getAmount());
		 psadcr.setLong(4,(currentbalance+(long)tob.getAmount()));
		 psadcr.executeUpdate();
		 
		 JOptionPane.showMessageDialog(AdminFrame.adminframe,"Successfully verified");
	 }
	 public String[][] getMiniStatement(int cid) throws Exception
	 {
		 String gminist[][]=new String[10][8];
		 psgmins=conn.prepareStatement("select * from atm_account_details_tb  where customerid="+cid+" order by trnsaction_date desc");
		 rsgmins=psgmins.executeQuery();
		 for(int i=0;i<10;i++)
		 {
			 rsgmins.next();
			 for(int j=0;j<8;j++)
			 {
				 //gminist[i][j]=rsgmins.getString(j+1);
			 }
			 
		 }
		 return gminist;
	 }

}
