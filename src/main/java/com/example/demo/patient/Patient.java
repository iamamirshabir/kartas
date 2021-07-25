package com.example.demo.patient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.medication.Medication;
import com.example.demo.scholarship.scholarship;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="patient_id")
	private Long patient_id;
	
	@Column(name="patient_name")
	private String patient_name;
	
	@Column(name="patient_hospital")
	private String patient_hospital;
	
	@Column(name="patient_cnic")
	private String patient_cnic;
	
	@Column(name="patient_email")
	private String patient_email;
	
	@Column(name="patient_mobile")
	private String patient_mobile;

	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "patient")
	private Medication medication;
	 
	public Long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Long patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_hospital() {
		return patient_hospital;
	}

	public void setPatient_hospital(String patient_hospital) {
		this.patient_hospital = patient_hospital;
	}

	public String getPatient_cnic() {
		return patient_cnic;
	}

	public void setPatient_cnic(String patient_cnic) {
		this.patient_cnic = patient_cnic;
	}

	public String getPatient_email() {
		return patient_email;
	}

	public void setPatient_email(String patient_email) {
		this.patient_email = patient_email;
	}

	public String getPatient_mobile() {
		return patient_mobile;
	}

	public void setPatient_mobile(String patient_mobile) {
		this.patient_mobile = patient_mobile;
	}

	public Patient() {
		super();
		
	}


	@JsonIgnore
	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public Patient(Long patient_id, String patient_name, String patient_hospital, String patient_cnic,
			String patient_email, String patient_mobile, Medication medication) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.patient_hospital = patient_hospital;
		this.patient_cnic = patient_cnic;
		this.patient_email = patient_email;
		this.patient_mobile = patient_mobile;
		this.medication = medication;
	}

	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id  + ", patient_name=" + patient_name
				+ ", patient_hospital=" + patient_hospital + ", patient_cnic=" + patient_cnic + ", patient_email="
				+ patient_email + ", patient_mobile=" + patient_mobile + "]";
	}
	
	
	
	
	

}
