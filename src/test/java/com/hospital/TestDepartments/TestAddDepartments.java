package com.hospital.testdepartments;

import java.util.Scanner;
import com.hospital.Departments;
import com.hospital.dao.DepartmentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestAddDepartments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		Departments d1 = new Departments();
		
		LOGGER.debug("Enter departmentName : ");
        
        d1.setDepartmentName(in.next()); 
        
        DepartmentsDAO dao = DAOFactory.getDepartmentsDAO();
		dao.addDepartment(d1);
        
		in.close();
		
		/*// input
		Departments d1 = new Departments();
		d1.departmentName = "Cardiology";

		// call dao
		DepartmentsDAOImpl daoImpl = new DepartmentsDAOImpl();
		daoImpl.addDepartment(d1);

		// input
		Departments d2 = new Departments();
		d2.departmentName = "Dermatology";

		// call dao
		DepartmentsDAOImpl daoImpl1 = new DepartmentsDAOImpl();
		daoImpl1.addDepartment(d2);

		// input
		Departments d3 = new Departments();
		d3.departmentName = "Pediatrician";

		// call dao
		DepartmentsDAOImpl daoImpl2 = new DepartmentsDAOImpl();
		daoImpl2.addDepartment(d3);

		// input
		Departments d4 = new Departments();
		d4.departmentName = "General Medicine";

		// call dao
		DepartmentsDAOImpl daoImpl3 = new DepartmentsDAOImpl();
		daoImpl3.addDepartment(d4);

		// input
		Departments d5 = new Departments();
		d5.departmentName = "ENT";

		// call dao
		DepartmentsDAOImpl daoImpl4 = new DepartmentsDAOImpl();
		daoImpl4.addDepartment(d5);

		// input
		Departments d6 = new Departments();
		d6.departmentName = "Dental";

		// call dao
		DepartmentsDAOImpl daoImpl5 = new DepartmentsDAOImpl();
		daoImpl5.addDepartment(d6);*/

		
		
	}
}
