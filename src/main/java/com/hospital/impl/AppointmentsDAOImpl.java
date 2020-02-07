package com.hospital.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hospital.Appointments;
import com.hospital.dao.AppointmentsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class AppointmentsDAOImpl implements AppointmentsDAO {

	private static final String ACTION_1 = "appointment_id";
	private static final String ACTION_2 = "purpose";
	private static final String ACTION_3 = "s_time";
	private static final String ACTION_4 = "e_time";
	private static final String ACTION_5 = "active_appointments";
	private static final Logger LOGGER = Logger.getInstance();
	
	public void addAppointments(Appointments app) throws SQLException, ClassNotFoundException
	{
		
		String sql = "insert into appointment (appointment_id, patient_id, purpose, doctor_id,s_time,e_time)values(appointment_id_sq.nextval,?,?,?,?,?)"; 
		LOGGER.debug(sql);
		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setInt(1, app.getPatientId());
			pst.setString(2, app.getPurpose());
			pst.setInt(3,app.getDoctorId()); 
			pst.setTimestamp(4, Timestamp.valueOf(app.getStartingTime()));
			pst.setTimestamp(5, Timestamp.valueOf((app.getStartingTime()).plus(Duration.of(30, ChronoUnit.MINUTES))));

			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows inserted " + rows);
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
	
	}

	public void updateAppointments(LocalDateTime startingTime, int appointmentId) throws ClassNotFoundException, SQLException {
		
		String sql = "Update appointment set s_time = ? where appointment_id = ?";
		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setTimestamp(1, Timestamp.valueOf(startingTime));
			pst.setInt(2, appointmentId);

			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows updated " + rows);
		
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
	}

	public List<Appointments> displayAppointments() throws ClassNotFoundException, SQLException {
		
		
		List<Appointments> list = new ArrayList<>();
		
		String sql = "select appointment_id, patient_id, purpose, doctor_id, s_time, e_time,active_appointments from appointment";
		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);){
			
			LOGGER.debug(rows);
			
			while (rows.next()) {
				String appId = rows.getString(ACTION_1);
				String patientId = rows.getString("patient_id");
				String purpose = rows.getString(ACTION_2);
				String docId = rows.getString("doctor_id");
				String sTime = rows.getString(ACTION_3);
				String eTime = rows.getString(ACTION_4);
				String activeApp = rows.getString(ACTION_5);			
				LOGGER.debug(appId+"-"+patientId+"-"+purpose+"-"+ "-"+docId+"-"+sTime+"-"+eTime+"-"+activeApp);
				Appointments d1 = new Appointments();
				list.add(d1);
			}
			
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return Collections.emptyList();
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
		String sql = "Select appointment_id, purpose, doctor_id, s_time, e_time, active_appointments from appointment where patient_id = ?";
		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rows = pst.executeQuery();) {
			pst.setInt(1, patientId);

			LOGGER.debug( "Select appointment_id,purpose, doctor_id, s_time, e_time, active_appointments from appointment where patient_id = "+patientId);
			LOGGER.debug("No of rows found: " + rows);
			
			while (rows.next()) {
				int appId = rows.getInt(ACTION_1);
				String purpose = rows.getString(ACTION_2);
				int doctorId = rows.getInt("doctor_id");
				String sTime = rows.getString(ACTION_3);
				String eTime = rows.getString(ACTION_4);
				int active = rows.getInt(ACTION_5);
				LOGGER.debug(appId+patientId+purpose+doctorId+sTime+eTime+active);
				Appointments d2 = new Appointments();
				list.add(d2);
				
			}
			
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}
	
public List<Appointments> doctorAppointments(int doctorId) throws SQLException, ClassNotFoundException {
		
		List<Appointments> list = new ArrayList<>();
		String sql = "Select appointment_id, purpose, patient_id, s_time, e_time, active_appointments from appointment where doctor_id = ?";
		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rows = pst.executeQuery();) {

			pst.setInt(1, doctorId);			
			LOGGER.debug(sql+doctorId);
			LOGGER.debug("No of rows found: " + rows);
			
			while (rows.next()) {
				int appId = rows.getInt(ACTION_1);
				String purpose = rows.getString(ACTION_2);
				int patientId = rows.getInt("patient_id");
				String sTime = rows.getString(ACTION_3);
				String eTime = rows.getString(ACTION_4);
				int active = rows.getInt(ACTION_5);
				LOGGER.debug(appId+patientId+purpose+patientId+sTime+eTime+active);
				Appointments d2 = new Appointments();
				list.add(d2);
				
			}
			
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}
}
