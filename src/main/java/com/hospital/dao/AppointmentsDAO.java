package com.hospital.dao;

import java.sql.SQLException;
import java.util.List;
import com.hospital.Appointments;

public interface AppointmentsDAO {

	//insert
	public void addAppointments(Appointments app) throws SQLException, ClassNotFoundException;
	
	//display
	List<Appointments> displayAppointments() throws ClassNotFoundException, SQLException;
	
	//delete
	public void deleteAppointments(int appointmentId) throws ClassNotFoundException, SQLException;
	
	//display by patient_id
	
	public List<Appointments> findMyAppointments(int patientId) throws SQLException, ClassNotFoundException;
	
	public List<Appointments> doctorAppointments(int doctorId) throws SQLException, ClassNotFoundException;
	
}
