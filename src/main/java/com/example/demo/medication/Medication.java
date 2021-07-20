package com.example.demo.medication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.patient.Patient;
import com.example.demo.student.Student;

@Entity
@Table(name="medication")
public class Medication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="medication_id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
	    private Patient patient;

	@Column(name="eligible")
	private boolean eligible;
	
	@Column(name="amount")
	private double amount;
	public Long getId() {
		return id;
	}
	public void setId(Long id2) {
		this.id = id2;
	}
	
	public boolean isEligible() {
		return eligible;
	}
	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Medication(Long id, Patient patient, boolean eligible, double amount) {
		super();
		this.id = id;
		this.patient = patient;
		this.eligible = eligible;
		this.amount = amount;
	}
	public Medication() {

	}
	
	
	
	

}
