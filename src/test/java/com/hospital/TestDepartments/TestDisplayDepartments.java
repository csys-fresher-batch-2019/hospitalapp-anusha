package com.hospital.testdepartments;

import com.hospital.dao.DepartmentsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayDepartments {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DepartmentsDAO dao= DAOFactory.getDepartmentsDAO();
		dao.displayDepartments();
	
	}

}
