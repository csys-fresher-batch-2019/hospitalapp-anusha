package com.hospital.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.hospital.Appointments;
import com.hospital.dao.AppointmentsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class AppointmentsDAOImpl implements AppointmentsDAO {

	private static final String ACTION_1 = "appointment_id";
	private static final String ACTION_2 = "purpose";
	private static final String ACTION_3 = "active_appointments";
	private static final Logger LOGGER = Logger.getInstance();
	
	public void addAppointments(Appointments app) throws SQLException, ClassNotFoundException
	{
		
		try(Connection con = ConnectionUtil.getconnection(); 
				CallableStatement stmt=con.prepareCall("{call appointment_fixing(?,?,?,?)}")){
			
			stmt.setInt(1, app.getPatientId());
			stmt.setString(2, app.getPurpose());
			stmt.setInt(3,app.getDoctorId()); 
			stmt.registerOutParameter(4, Types.VARCHAR);
			stmt.executeUpdate();
			String status=stmt.getString(4);
			LOGGER.debug(status);
		}
		catch (Exception e) {
			LOGGER.debug(e);
		}
	
	}

	public List<Appointments> displayAppointments() throws ClassNotFoundException, SQLException {
				
		List<Appointments> list = new ArrayList<>();
		
		String sql = "select appointment_id, patient_id, purpose, doctor_id, active_appointments,appointment_status from appointment";
		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);){
			
			LOGGER.debug(rows);
			
			while (rows.next()) {
				int appId = rows.getInt(ACTION_1);
				int patientId = rows.getInt("patient_id");
				String purpose = rows.getString(ACTION_2);
				int docId = rows.getInt("doctor_id");
				int activeApp = rows.getInt(ACTION_3);		
				String appointmentStatus= rows.getString("appointment_status");
				LOGGER.debug(appId+""+patientId+""+purpose+""+docId+""+activeApp+""+appointmentStatus);
				Appointments d1 = new Appointments();
				d1.setActive(activeApp);
				d1.setPatientId(patientId);
				d1.setDoctorId(docId);
				d1.setAppointmentId(appId);
				d1.setPurpose(purpose);
				d1.setAppointmentStatus(appointmentStatus);
				list.add(d1);
			}
			
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}

	public void deleteAppointments(int appointmentId) throws ClassNotFoundException, SQLException {
		
		String sql = "Update appointment set active_appointments = 0 where appointment_id = ?";
		LOGGER.debug(sql);
		
		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);){

			pst.setInt(1, appointmentId);

			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows deleted " + rows);
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		
	}
	
	public List<Appointments> findMyAppointments(int patientId) throws SQLException, ClassNotFoundException {
		
		List<Appointments> list = new ArrayList<>();
		String sql = "Select appointment_id,patient_id, purpose, doctor_id, active_appointments, appointment_status from appointment where patient_id = ?";
		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql); ) {
			pst.setInt(1, patientId);

			LOGGER.debug( sql+patientId);
			try(ResultSet rows = pst.executeQuery();){
			LOGGER.debug("No of rows found: " + rows);
			
			while (rows.next()) {
				int appId = rows.getInt(ACTION_1);
				String purpose = rows.getString(ACTION_2);
				int doctorId = rows.getInt("doctor_id");
				int active = rows.getInt(ACTION_3);
				String appointmentStatus= rows.getString("appointment_status");
				int patId = rows.getInt("patient_id");
				
				Appointments d1 = new Appointments();
				
				d1.setAppointmentId(appId);			
				d1.setDoctorId(doctorId);
				d1.setPatientId(patId);
				d1.setPurpose(purpose);
				d1.setAppointmentStatus(appointmentStatus);
				d1.setActive(active);
						
				list.add(d1);
				LOGGER.debug(appId+" "+purpose+" "+doctorId+" "+active +" "+ appointmentStatus );
			}
			}
			
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}
	
public List<Appointments> doctorAppointments(int doctorId) throws SQLException, ClassNotFoundException {
		
		List<Appointments> list = new ArrayList<>();
		String sql = "Select appointment_id, purpose, doctor_id, patient_id, active_appointments ,appointment_status from appointment where doctor_id = ?";
		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql); ) {

			pst.setInt(1, doctorId);			
			LOGGER.debug(sql+doctorId);
			
			try(ResultSet rows = pst.executeQuery();){
				LOGGER.debug("No of rows found: " + rows);
				
				while (rows.next()) {
				int appId = rows.getInt(ACTION_1);
				String purpose = rows.getString(ACTION_2);
				int patientId = rows.getInt("patient_id");
				int active = rows.getInt(ACTION_3);
				String appointmentStatus=rows.getString("appointment_status");
				Appointments d2 = new Appointments();
				
				d2.setAppointmentId(appId);
				d2.setPurpose(purpose);
				d2.setDoctorId(doctorId);
				d2.setPatientId(patientId);
				d2.setActive(active);
				d2.setAppointmentStatus(appointmentStatus);
				
				list.add(d2);
				
				LOGGER.debug(appId+" "+purpose+" "+patientId+" "+active );
				
			}
			}
			
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}
}
