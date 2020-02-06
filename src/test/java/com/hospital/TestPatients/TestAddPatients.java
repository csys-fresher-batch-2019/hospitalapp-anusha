package com.hospital.testPatients;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import com.hospital.Patients;
import com.hospital.dao.PatientsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestAddPatients {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		Patients d1 = new Patients();

		PatientsDAO dao = DAOFactory.getPatientsDAO();

		LOGGER.debug("Enter patientName : ");
		d1.setPatientName(in.next());

		LOGGER.debug("Enter age : ");
		d1.setAge(in.nextInt());

		LOGGER.debug("Enter gender : ");
		d1.setGender(in.next());
		
		LOGGER.debug("Enter weight : ");
		d1.setWeight(in.nextInt());

		LOGGER.debug("Enter address : ");
		d1.setAddress(in.next());

		LOGGER.debug("Enter phoneNumber : ");
		d1.setPhoneNumber(in.next());

		LOGGER.debug("Enter disease : ");
		d1.setDisease(in.next());

		dao.joinDepartmentsDoctors();

		LOGGER.debug("Enter doctorId : ");
		d1.setDoctorId(in.nextInt());
		
		LOGGER.debug("Enter patientType : ");
		d1.setPatientType(in.next());
		
		LOGGER.debug("Enter entryDate : ");
		d1.setEntryDate(LocalDateTime.parse(in.next()));

		dao.addPatients(d1);
		
		in.close();
		
		// d2.displayDepartments();

		/*
		 * LOGGER.debug("Enter departmentId : "); d1.departmentId = in.nextInt();
		 * 
		 * DoctorsDAOImpl daoImpl = new DoctorsDAOImpl(); daoImpl.addDoctors(d1);
		 * 
		 *
		 * 
		 * Patients d1 = new Patients(); 
		 * d1.patientName = "Ammu"; 
		 * d1.age = 34; 
		 * d1.weight= 54; 
		 * d1.address = "Singanallur"; 
		 * d1.phoneNumber = "9182656261"; 
		 * d1.gender = "F"; 
		 * d1.disease = "ALLERGY"; 
		 * d1.doctorID = 4; 
		 * d1.patientType = "IN";
		 * d1.entryDate = LocalDateTime.parse("2020-01-01T12:30:00") ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl1 = new PatientsDAOImpl();
		 * daoImpl1.addPatients(d1);
		 * 
		 * Patients d2 = new Patients(); d2.patientName = "Dhaya"; d2.age = 27;
		 * d2.weight = 75; d2.gender = "M"; d2.address = "Hopes"; d2.phoneNumber =
		 * "3648573489"; d2.disease = "GENERAL CHECK-UP"; d2.doctorID = 9;
		 * d2.patientType = "OUT"; d2.entryDate =
		 * LocalDateTime.parse("2020-01-02T02:37:02") ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl2 = new PatientsDAOImpl();
		 * daoImpl2.addPatients(d2);
		 * 
		 * Patients d3 = new Patients(); d3.patientName = "Derick"; d3.age = 10;
		 * d3.weight = 38; d3.gender = "M"; d3.address = "Sulur"; d3.phoneNumber =
		 * "2768756868"; d3.disease = "TOOTH ACHE"; d3.doctorID = 6; d3.patientType =
		 * "OUT"; d3.entryDate = LocalDateTime.parse("2020-01-25T06:22:04")
		 * ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl3 = new PatientsDAOImpl();
		 * daoImpl3.addPatients(d3);
		 * 
		 * Patients d4 = new Patients(); d4.patientName = "Nandhu"; d4.age = 03;
		 * d4.weight = 10; d4.gender = "M"; d4.address = "Varatharajapuram";
		 * d4.phoneNumber = "9858876451"; d4.disease = "FEVER"; d4.doctorID = 8;
		 * d4.patientType = "IN"; d4.entryDate =
		 * LocalDateTime.parse("2020-01-18T18:35:06") ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl4 = new PatientsDAOImpl();
		 * daoImpl4.addPatients(d4);
		 * 
		 * Patients d5 = new Patients(); d5.patientName = "Arun"; d5.age = 60; d5.weight
		 * = 79; d5.gender = "M"; d5.address = "Goldwins"; d5.phoneNumber =
		 * "9754873675"; d5.disease = "CARDIAC ARREST"; d5.doctorID = 10; d5.patientType
		 * = "IN"; d5.entryDate = LocalDateTime.parse("2020-01-02T23:11:08")
		 * ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl5 = new PatientsDAOImpl();
		 * daoImpl5.addPatients(d5);
		 * 
		 * Patients d6 = new Patients(); d6.patientName = "Nivi"; d6.age = 19; d6.weight
		 * = 44; d6.gender = "F"; d6.address = "Kelambakkam"; d6.phoneNumber =
		 * "0823697765"; d6.disease = "HEAD ACHE"; d6.doctorID = 3; d6.patientType =
		 * "OUT"; d6.entryDate = LocalDateTime.parse("2020-01-20T20:44:10")
		 * ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl6 = new PatientsDAOImpl();
		 * daoImpl6.addPatients(d6);
		 * 
		 * Patients d7 = new Patients(); d7.patientName = "Krithi"; d7.age = 33;
		 * d7.weight = 77; d7.gender = "F"; d7.address = "Gandhipuram"; d7.phoneNumber =
		 * "9768854783"; d7.disease = "CAVITY"; d7.doctorID = 6; d7.patientType = "OUT";
		 * d7.entryDate = LocalDateTime.parse("2020-01-12T05:22:12") ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl7 = new PatientsDAOImpl();
		 * daoImpl7.addPatients(d7);
		 * 
		 * Patients d8 = new Patients(); d8.patientName = "Kiruba"; d8.age = 22;
		 * d8.weight = 55; d8.gender = "F"; d8.address = "Trichy"; d8.phoneNumber =
		 * "6756478657"; d8.disease = "HEARING LOSS"; d8.doctorID = 5; d8.patientType =
		 * "OUT"; d8.entryDate = LocalDateTime.parse("2020-01-23T08:56:14")
		 * ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl8 = new PatientsDAOImpl();
		 * daoImpl8.addPatients(d8);
		 * 
		 * Patients d9 = new Patients(); d9.patientName = "Aarik"; d9.age = 98;
		 * d9.weight = 70; d9.gender = "M"; d9.address = "Sholinganallur";
		 * d9.phoneNumber = "3847567867"; d9.disease = "COMMON COLD"; d9.doctorID = 1;
		 * d9.patientType = "OUT"; d9.entryDate =
		 * LocalDateTime.parse("2020-01-28T03:50:16") ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl9 = new PatientsDAOImpl();
		 * daoImpl9.addPatients(d9);
		 * 
		 * Patients d10 = new Patients(); d10.patientName = "Manju"; d10.age = 45;
		 * d10.weight = 68; d10.gender = "M"; d10.address = "Tirupur"; d10.phoneNumber =
		 * "8345646570"; d10.disease = "ATHEROSCLEROSIS"; d10.doctorID = 2;
		 * d10.patientType = "IN"; d10.entryDate =
		 * LocalDateTime.parse("2020-01-02T10:40:18") ;//yyyy-MM-dd
		 * 
		 * // call dao PatientsDAOImpl daoImpl10 = new PatientsDAOImpl();
		 * daoImpl10.addPatients(d10);
		 */

	}

}
