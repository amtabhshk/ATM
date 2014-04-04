package com.wipro.atm.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.atm.dao.Userdao;
import com.wipro.atm.entity.User;

public class Authentication {
	
	public String authenticate(User uob) throws Exception
	{
		
		String utype="";
		int uid=uob.getUserid();
		
		String enteredpassword=uob.getPassword();//password[0]=password,password[1]=user_type
		Userdao udao=new Userdao();
		String password[]=new String[2];
		password=udao.findByUserId(uid);
		
		if(password[0].equals(enteredpassword))
		{
			utype=password[1];
		}
		
		return utype;
	}

}

