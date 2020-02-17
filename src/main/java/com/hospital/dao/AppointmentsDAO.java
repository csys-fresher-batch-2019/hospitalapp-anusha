package com.hospital.dao;

import java.sql.SQLException;
import java.util.List;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.hospital.Appointments;

public interface AppointmentsDAO {

	//insert
	@SqlUpdate("call appointment_fixing(?,?,?,?)")
	public void addAppointments(@BindBean Appointments app) throws SQLException, ClassNotFoundException;
	
	//display
	@SqlUpdate("select appointment_id, patient_id, purpose, doctor_id, active_appointments,appointment_status from appointment")
	List<Appointments> displayAppointments() throws ClassNotFoundException, SQLException;
	
	//delete
	@SqlUpdate("Update appointment set active_appointments = 0 where appointment_id = ?")
	public void deleteAppointments(int appointmentId) throws ClassNotFoundException, SQLException;
	
	//display by patient_id
	@SqlUpdate("Select appointment_id, purpose, doctor_id, active_appointments, appointment_status from appointment where patient_id = ?")
	public List<Appointments> findMyAppointments(int patientId) throws SQLException, ClassNotFoundException;
	
	@SqlUpdate("Select appointment_id, purpose, patient_id, active_appointments from appointment where doctor_id = ?")
	public List<Appointments> doctorAppointments(int doctorId) throws SQLException, ClassNotFoundException;
	
}
