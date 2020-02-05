package com.hospital;

import java.time.LocalDateTime;

public class Payments {

	private int billNo;
	private int patientId;
	private int totalAmount;
	private int amountPaid;
	private int pendingAmount;
	private LocalDateTime billDate;
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

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}

	private String status;
	
	
	public int getPendingAmount() {
		return pendingAmount;
	}
	
	public void setPendingAmount(int pendingAmount) {
		this.pendingAmount = totalAmount-amountPaid;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		if(pendingAmount != 0)
			this.status = "PAID";
		else
			this.status = "UNPAID";	
	}
	
}

