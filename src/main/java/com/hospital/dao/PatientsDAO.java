package com.hospital.dao;

import java.sql.SQLException;
import java.util.List;
import com.hospital.Doctors;
import com.hospital.Patients;

public interface PatientsDAO {
	
	//insert
	void addPatients(Patients p) throws ClassNotFoundException, SQLException;
	
	//display
	List<Patients> displayPatients() throws ClassNotFoundException, SQLException ;
	
	//delete 
	void deletePatients(int patientId) throws ClassNotFoundException, SQLException;

	//doc list
	public List<Doctors> joinDepartmentsDoctors() throws SQLException, ClassNotFoundException;

	//profile
	public List<Patients> findMyProfile(int patientId) throws SQLException, ClassNotFoundException;

}
