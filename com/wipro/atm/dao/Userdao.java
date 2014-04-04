package com.wipro.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.atm.entity.User;
import com.wipro.atm.util.*;

public class Userdao {
Connection conn;
ResultSet rs;
PreparedStatement createuserpst,deleteuserpst,modifyuserpst,countadminpst,modifyusertypepst,findbyuseridpst;
      public Userdao() throws Exception
      {
    	  DbUtil du=new DbUtil();
    	  this.conn=du.createDbCon();
      }
    public  void createUser(User uob) throws Exception
    {
    	String password=uob.getPassword();
    	String usertype=uob.getUsertype();
    	int uid=uob.getUserid();
    	createuserpst=conn.prepareStatement("insert into atm_user_tb values(?,?,?,'N')");
    	createuserpst.setInt(1,uid);
    	createuserpst.setString(2,password);
    	createuserpst.setString(3,usertype);
    	createuserpst.executeUpdate();
    }
    public void deleteUser(int uid) throws Exception
    {
    	deleteuserpst=conn.prepareStatement("delete from atm_user_tb where userid=(?)");
    	deleteuserpst.setInt(1,uid);
    	deleteuserpst.executeUpdate();
    }
    public boolean modifyPassword(int uid,String newpassword) throws Exception
    {
    	modifyuserpst=conn.prepareStatement("update atm_user_tb set password=(?) where userid=(?)");
    	modifyuserpst.setString(1,newpassword);
    	modifyuserpst.setInt(2,uid);
    	modifyuserpst.executeUpdate();
    	return true;
    }
    public int countAdmin() throws Exception
    {
    	countadminpst=conn.prepareStatement("select count(*) from atm_user_tb where usertype='admin'");
    	rs=countadminpst.executeQuery();
    	rs.next();
    	 int count=rs.getInt(1);
    	 return count;
    }

    	 
    public void modifyUserType(int uid,String utype) throws Exception
    {
    	modifyusertypepst=conn.prepareStatement("update atm_user_tb set user_type=(?) where userid=(?)");
    	modifyusertypepst.setString(1,utype);
    	modifyusertypepst.setInt(2,uid);
    	modifyusertypepst.executeUpdate();
    	
    }
    public String[] findByUserId(int uid) throws Exception
    {
    	 String passwordutype[]=new String[2];
    	 findbyuseridpst=conn.prepareStatement("select password,user_type from atm_user_tb where userid=(?)");
    	 findbyuseridpst.setInt(1,uid);
    	rs=findbyuseridpst.executeQuery();
    	rs.next();
    	 passwordutype[0]=rs.getString(1);
    	 passwordutype[1]=rs.getString(2);
    	
    	 return passwordutype;
    	
    }
    
}
