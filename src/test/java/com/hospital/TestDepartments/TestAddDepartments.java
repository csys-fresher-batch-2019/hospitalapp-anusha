package com.hospital.testDepartments;

import java.util.Scanner;
import com.hospital.Departments;
import com.hospital.dao.DepartmentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestAddDepartments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		Departments d1 = new Departments();
		
		LOGGER.debug("Enter departmentName : ");
        
        d1.setDepartmentName(in.next()); 
        
        DepartmentsDAO dao = DAOFactory.getDepartmentsDAO();
		dao.addDepartment(d1);
        
		in.close();
		
	}
}
