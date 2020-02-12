package com.hospital.testDoctors;

import java.sql.SQLException;

import com.hospital.dao.DoctorsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayDoctors {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DoctorsDAO dao = DAOFactory.getDoctorsDAO();
		dao.displayDoctors();
		
	}

}
