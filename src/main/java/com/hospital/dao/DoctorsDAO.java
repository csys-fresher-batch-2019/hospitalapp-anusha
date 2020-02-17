package com.hospital.dao;

import java.sql.SQLException;
import java.util.List;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.hospital.Doctors;

public interface DoctorsDAO {

	//insert
	@SqlUpdate("insert into doctors (doctor_id,doctor_name,department_id,doctor_password,d_phone_number,d_gender) values(doctor_id_sq.nextval,?,?,?,?,?)")
	void addDoctors(@BindBean Doctors doc) throws ClassNotFoundException, SQLException;
	
	//display
	@SqlUpdate("select doctor_id,doctor_name,department_id,active_doctors,doctor_presence,d_phone_number,d_gender,no_of_appointments from doctors")
	List<Doctors> displayDoctors() throws ClassNotFoundException, SQLException ;
	
	//delete 
	@SqlUpdate("Update doctors set active_doctors = 0 where doctor_id = ?")
	void deleteDoctors(int departmentId) throws ClassNotFoundException, SQLException;
	
	//search
	@SqlUpdate("Select doctor_id,department_id,active_doctors,doctor_presence from doctors where doctor_name = ?")
	public List<Doctors> findDoctorByName(String doctorName) throws SQLException, ClassNotFoundException;
	
	//doc present
	@SqlUpdate("Select doctor_id,department_id,doctor_name from doctors where doctor_presence = 1")
	public List<Doctors> doctorsPresent();
}
