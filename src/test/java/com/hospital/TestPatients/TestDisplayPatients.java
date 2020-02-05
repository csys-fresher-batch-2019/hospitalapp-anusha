package com.hospital.TestPatients;

import java.sql.SQLException;

import com.hospital.DAO.PatientsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayPatients {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		PatientsDAO dao = DAOFactory.getPatientsDAO();
		dao.displayPatients();
		
	}

}
