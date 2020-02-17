package com.hospital.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hospital.dao.AdminDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class AdminDAOImpl implements AdminDAO {
	private static final Logger LOGGER = Logger.getInstance();

	public String login(String adminName, String passWord) throws SQLException, ClassNotFoundException {
		String sql = "select admin_name,admin_password from admin_table where adminname='" + adminName
				+ "' and password='" + passWord + "'";
		try (Connection connection = ConnectionUtil.getconnection(); Statement stmt = connection.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				LOGGER.debug(sql);
				String st = null;
				if (rs.next()) {
					st = "success";
					String adminName1 = rs.getString("admin_name");
					// LOGGER.debug(adminName1);
					String Password = rs.getString("admin_password");
					// LOGGER.debug(Password);
					if (adminName.equals(adminName1) && passWord.equals(Password)) {

						LOGGER.debug("Login Successfull");
						return st;

					}

				} else {
					st = "failed";
					LOGGER.debug("Login failed");
					return st;
				}
			} catch (Exception e) {
				LOGGER.debug(e);
			}
			return null;
		}
	}

}