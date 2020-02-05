package com.hospital.TestDepartments;

import com.hospital.DAO.DepartmentsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayDepartments {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DepartmentsDAO dao= DAOFactory.getDepartmentsDAO();
		dao.displayDepartments();
	
	}

}
