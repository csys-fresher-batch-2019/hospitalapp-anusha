package com.hospital.DAO;

import java.sql.SQLException;
import java.util.List;

import com.hospital.Patients;

public interface PatientsDAO {
	
	//insert
	void addPatients(Patients p) throws ClassNotFoundException, SQLException;
	
	//update
	void updatePatientsweight(int age, String patientId) throws ClassNotFoundException, SQLException;
	
	//display
	List<Patients> displayPatients() throws ClassNotFoundException, SQLException ;
	
	//delete 
	void deletePatients(int patientId) throws ClassNotFoundException, SQLException;

	public String[] joinDepartmentsDoctors() throws SQLException, ClassNotFoundException;

	public List<Patients> findMyProfile(int patientId) throws SQLException, ClassNotFoundException;

}
