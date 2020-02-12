package com.hospital;

import java.time.LocalDateTime;

public class Payments {

	private int billNo;
	private int patientId;
	private int totalAmount;
	private int amountPaid;
	private int pendingAmount;
	private LocalDateTime billDateTime;
	private String payStatus;
	private int activeBills=1;
	
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	public int getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(int pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	public LocalDateTime getBillDateTime() {
		return billDateTime;
	}
	public void setBillDateTime(LocalDateTime billDateTime) {
		this.billDateTime = billDateTime;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public int getActiveBills() {
		return activeBills;
	}
	public void setActiveBills(int activeBills) {
		this.activeBills = activeBills;
	}

}
