package com.hospital.dao;

import java.sql.SQLException;
import java.util.List;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.hospital.Doctors;
import com.hospital.Patients;

public interface PatientsDAO {
	
	//insert
	@SqlUpdate("insert into patient (patient_id, patient_name, age, address, p_phone_number, p_gender,patient_password) values (patient_id_sq.nextval,?, ?, ?, ?, ?, ?)")
	void addPatients(@BindBean Patients p) throws ClassNotFoundException, SQLException;
	
	//display
	@SqlUpdate("select patient_id,patient_name,age, p_gender, address, p_phone_number, active_patients from patient")
	List<Patients> displayPatients() throws ClassNotFoundException, SQLException ;
	
	//delete 
	@SqlUpdate("update active_patients=0 from patient where patient_id = ?")
	void deletePatients(int patientId) throws ClassNotFoundException, SQLException;

	//doc list
	@SqlUpdate("select d.doctor_name,s.department_name,d.doctor_id from doctors d join departments s on d.department_id = s.department_id ")
	public List<Doctors> joinDepartmentsDoctors() throws SQLException, ClassNotFoundException;

	//profile
	@SqlUpdate("Select patient_name, age, address, p_phone_number, p_gender from patient where patient_id = ?")
	public List<Patients> findMyProfile(int patientId) throws SQLException, ClassNotFoundException;

}
