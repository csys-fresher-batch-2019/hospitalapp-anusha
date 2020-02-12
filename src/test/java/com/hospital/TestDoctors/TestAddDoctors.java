package com.hospital.testDoctors;

import java.util.Scanner;
import com.hospital.Doctors;
import com.hospital.dao.DepartmentsDAO;
import com.hospital.dao.DoctorsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestAddDoctors {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
        Doctors d1 = new Doctors();
        
        DepartmentsDAO d2 = DAOFactory.getDepartmentsDAO();
        
        LOGGER.debug("Enter doctorName : ");
        d1.setDoctorName(in.next()); 
        
        d2.displayDepartments();
        
        LOGGER.debug("Enter departmentId : ");
        d1.setDepartmentId(in.nextInt());
        
        LOGGER.debug("Enter password : ");
        d1.setDoctorPassword(in.next());
        
        LOGGER.debug("Enter dPhoneNumber : ");
        d1.setdPhoneNumber(in.next());
        
        LOGGER.debug("Enter dGender : ");
        d1.setdGender(in.next());
        
        DoctorsDAO dao = DAOFactory.getDoctorsDAO();
		dao.addDoctors(d1);

		in.close();

	}

}
