package com.hospital;

import java.time.LocalDateTime;

public class Appointments {
	
	private int appointmentId;
	private int patientId;
	private String purpose;
	private int doctorId;
	private LocalDateTime startingTime;
	private LocalDateTime endingTime;
	private int active=1;
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public LocalDateTime getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(LocalDateTime startingTime) {
		this.startingTime = startingTime;
	}
	public LocalDateTime getEndingTime() {
		return endingTime;
	}
	public void setEndingTime(LocalDateTime endingTime) {
		this.endingTime = endingTime;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
}