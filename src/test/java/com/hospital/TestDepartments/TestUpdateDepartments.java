package com.hospital.testDepartments;

import java.util.Scanner;

import com.hospital.dao.DepartmentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestUpdateDepartments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DepartmentsDAO d1 = DAOFactory.getDepartmentsDAO();
		
		Scanner in = new Scanner(System.in);
		
        LOGGER.debug("Enter active status : ");
        int active = in.nextInt(); 
        
        LOGGER.debug(d1.displayDepartments());
        
        LOGGER.debug("Enter departmentId  : "); 
        int departmentId = in.nextInt(); 
        		
		d1.updateDepartment(active, departmentId);
		
		in.close();
	}

}
