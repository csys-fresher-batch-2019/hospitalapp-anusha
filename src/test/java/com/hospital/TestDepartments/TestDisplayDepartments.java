package com.hospital.testDepartments;

import com.hospital.dao.DepartmentsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayDepartments {

	public static void main(String[] args) throws Exception {

		DepartmentsDAO dao= DAOFactory.getDepartmentsDAO();
		dao.displayDepartments();
	
	}

}
