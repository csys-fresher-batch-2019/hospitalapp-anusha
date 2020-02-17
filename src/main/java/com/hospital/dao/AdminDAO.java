package com.hospital.dao;

import java.sql.SQLException;

public interface AdminDAO {

	public String login(String adminName, String passWord) throws SQLException, ClassNotFoundException;

}
