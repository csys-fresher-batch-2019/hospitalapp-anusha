package com.hospital.TestDoctors;

import java.sql.SQLException;

import com.hospital.hospitalDAO.DoctorsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayDoctors {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		DoctorsDAO dao = DAOFactory.getDoctorsDAO();
		dao.displayDoctors();
		
	}

}
