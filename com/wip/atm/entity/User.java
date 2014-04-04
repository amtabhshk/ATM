package com.wipro.atm.entity;

import com.wipro.atm.dao.Userdao;
import com.wipro.atm.entity.*;
import com.wipro.atm.util.Authentication;
import com.wipro.atm.util.DbUtil;
public class User {
int userid;
String password;
String usertype;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsertype() {
	return usertype;
}
public void setUsertype(String usertype) {
	this.usertype = usertype;
}
public boolean changePassword(int uid,String oldpassword,String newpassword) throws Exception
{
	boolean success=false;
	Userdao ud=new Userdao();
	String oldpasswordretrived[]=new String[2];
	oldpasswordretrived=ud.findByUserId(uid);
	
	if(oldpassword==oldpasswordretrived[0])
	{
		success=ud.modifyPassword(uid,newpassword);
	}
	
	return success;
}
public void login() throws Exception
{
	
	/*User uob=new User();
	uob.setUserid(uid);
	uob.setPassword(password);
	Authentication aob=new Authentication(); 
	String utype=aob.authenticate(uob);
	return utype;*/
}
public boolean logout() throws Exception
{
	//boolean success=false;
	DbUtil du=new DbUtil();
	du.closeDbCon();
	return true;
}


}
