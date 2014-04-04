package com.wipro.atm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	Class c;
	Connection conn;
	public Connection createDbCon() throws Exception
	{
		c=Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	return conn;
	}
  public void closeDbCon() throws Exception
  {
	  conn.close();
  }
}
