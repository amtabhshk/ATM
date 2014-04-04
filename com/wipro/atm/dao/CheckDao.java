package com.wipro.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import oracle.jdbc.driver.UpdatableResultSet;

import com.wipro.atm.entity.Check;
import com.wipro.atm.ui.DepositCheckFrame;
import com.wipro.atm.util.DbUtil;
import com.wipro.atm.util.Transaction;

public class CheckDao {
	Connection conn;
	ResultSet rscchk,rsgchk,rsapchk;
	PreparedStatement pscchk,psgchk,psapchk,psuchks;
	
	public CheckDao() throws Exception {
		 DbUtil du=new DbUtil();
	   	  this.conn=du.createDbCon();
		
	}
	public void createCheck(Check chob) throws Exception
	{
		
		pscchk=conn.prepareStatement("insert into atm_check_details_tb values(?,?,?,?,?,'N',sysdate,?)");
		pscchk.setInt(1,chob.getCustomerid());
		pscchk.setString(2,chob.getCustomername());
		pscchk.setInt(3,chob.getCheckno());
		pscchk.setLong(4,chob.getCheckamount());
		pscchk.setInt(5,chob.getBranchidofcheck());
		pscchk.setString(6,chob.getCheckissuedate());
		pscchk.executeUpdate();
		JOptionPane.showMessageDialog(DepositCheckFrame.depositckeckframe,"Successfully added");
	}
	public String[][] getcheck() throws Exception
	{
		int i=0,j=0;
		String [][]gchk=new String[20][8];
		psgchk=conn.prepareStatement("select * from atm_check_details_tb");
		rsgchk=psgchk.executeQuery();
		
		while(rsgchk.next())
		{
			for(i=0;i<8;i++)
			{
				
			    gchk[j][i]=rsgchk.getString((i+1));
			    //System.out.println("in getcheck="+gchk[j][i]);
		    }
			j++;
		}
		return gchk;
		
	}
	public void approveCheck(int chno) throws Exception
	{
		System.out.println("chno="+chno);
		psapchk=conn.prepareStatement("select check_bal,customerid from atm_check_details_tb where check_no="+chno);
		rsapchk=psapchk.executeQuery();
		rsapchk.next();
		int chkbal=rsapchk.getInt(1);
		int custmid=rsapchk.getInt(2);
		Transaction tsn=new Transaction();
		tsn.setAmount(chkbal);
		tsn.setCustomerid(custmid);
		new AccountDao().addCredit(tsn);
		
		psuchks=conn.prepareStatement("update atm_check_details_tb set status='Y' where check_no="+chno);
		psuchks.executeUpdate();
		
	}
}
