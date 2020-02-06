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
		// TODO Auto-generated method stub
		
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
        
        DoctorsDAO dao = DAOFactory.getDoctorsDAO();
		dao.addDoctors(d1);

		in.close();
		
		/*// input
		Doctors d1 = new Doctors();
		d1.doctorName = "Sruthi";
		d1.departmentId = 4;

		// call dao
		DoctorsDAOImpl daoImpl = new DoctorsDAOImpl();
		daoImpl.addDoctors(d1);

		// input
		Doctors d2 = new Doctors();
		d2.doctorName = "Megala";
		d2.departmentId = 1;

		// call dao
		DoctorsDAOImpl daoImpl1 = new DoctorsDAOImpl();
		daoImpl1.addDoctors(d2);

		// input
		Doctors d3 = new Doctors();
		d3.doctorName = "Aakashini";
		d3.departmentId = 4;

		// call dao
		DoctorsDAOImpl daoImpl2 = new DoctorsDAOImpl();
		daoImpl2.addDoctors(d3);

		// input
		Doctors d4 = new Doctors();
		d4.doctorName = "Bavi";
		d4.departmentId = 2;

		// call dao
		DoctorsDAOImpl daoImpl3 = new DoctorsDAOImpl();
		daoImpl3.addDoctors(d4);

		// input
		Doctors d5 = new Doctors();
		d5.doctorName = "Swaathi";
		d5.departmentId = 5;

		// call dao
		DoctorsDAOImpl daoImpl4 = new DoctorsDAOImpl();
		daoImpl4.addDoctors(d5);

		// input
		Doctors d6 = new Doctors();
		d6.doctorName = "Krithika";
		d6.departmentId = 6;

		// call dao
		DoctorsDAOImpl daoImpl5 = new DoctorsDAOImpl();
		daoImpl5.addDoctors(d6);

		// input
		Doctors d7 = new Doctors();
		d7.doctorName = "Meera";
		d7.departmentId = 6;

		// call dao
		DoctorsDAOImpl daoImpl6 = new DoctorsDAOImpl();
		daoImpl6.addDoctors(d7);

		// input
		Doctors d8 = new Doctors();
		d8.doctorName = "Nandhini";
		d8.departmentId = 3;

		// call dao
		DoctorsDAOImpl daoImpl7 = new DoctorsDAOImpl();
		daoImpl7.addDoctors(d8);

		// input
		Doctors d9 = new Doctors();
		d9.doctorName = "Darshini";
		d9.departmentId = 4;

		// call dao
		DoctorsDAOImpl daoImpl8 = new DoctorsDAOImpl();
		daoImpl8.addDoctors(d9);

		// input
		Doctors d10 = new Doctors();
		d10.doctorName = "Dhana";
		d10.departmentId = 1;

		// call dao
		DoctorsDAOImpl daoImpl9 = new DoctorsDAOImpl();
		daoImpl9.addDoctors(d10);*/
		
		
	}

}
