package com.wipro.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sun.management.snmp.AdaptorBootstrap;

import com.wipro.atm.entity.Branch;
import com.wipro.atm.ui.AddBranchDetailFrame;
import com.wipro.atm.ui.DepositCheckFrame;
import com.wipro.atm.util.DbUtil;

public class BranchDao {

	Connection conn;
	
	
	 public BranchDao() throws Exception
	 {
		 DbUtil du=new DbUtil();
	   	  this.conn=du.createDbCon();
}
	 
	 public void createBranch(Branch bch) throws Exception
	 {
		 PreparedStatement cbp=conn.prepareStatement("insert into atm_branch_details_tb values(?,?,?)");
		 cbp.setString(1,bch.getBranchname());
		 cbp.setInt(2,bch.getBranchid());
		 cbp.setString(3,bch.getBranchaddress());
		 cbp.executeUpdate();
		 JOptionPane.showMessageDialog(AddBranchDetailFrame.addbranchdetailframe,"Successfully added");
		 AddBranchDetailFrame.addbranchdetailframe.dispose();
	 }
}
