package com.hospital.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getconnection() throws SQLException, ClassNotFoundException
	{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","oracle");
	return connection;
	
	}

}
