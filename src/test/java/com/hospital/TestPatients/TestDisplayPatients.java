package com.hospital.testpatients;

import java.sql.SQLException;

import com.hospital.dao.PatientsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayPatients {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		PatientsDAO dao = DAOFactory.getPatientsDAO();
		dao.displayPatients();
		
	}

}
