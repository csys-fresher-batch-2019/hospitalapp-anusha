package com.hospital.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class ConnectionUtil {
	
	
	 private ConnectionUtil() {
		    throw new IllegalStateException("Utility class");
		  }
	 
	public static Connection getconnection() throws SQLException, ClassNotFoundException
	{
		 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	return (DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","oracle"));
	
	}
	
	public static Jdbi getJdbi() {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getconnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Jdbi jdbi = Jdbi.create(connection);
		jdbi.installPlugin(new SqlObjectPlugin());
		return jdbi;
	}

}
