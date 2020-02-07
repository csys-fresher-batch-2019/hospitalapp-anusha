package com.hospital.dao;

import java.sql.SQLException;
import java.util.List;

import com.hospital.Doctors;

public interface DoctorsDAO {

	//insert
	void addDoctors(Doctors doc) throws ClassNotFoundException, SQLException;
	
	//display
	List<Doctors> displayDoctors() throws ClassNotFoundException, SQLException ;
	
	//delete 
	void deleteDoctors(int departmentId) throws ClassNotFoundException, SQLException;
	
	//search
	public List<Doctors> findDoctorByName(String doctorName) throws SQLException, ClassNotFoundException;
	
}
