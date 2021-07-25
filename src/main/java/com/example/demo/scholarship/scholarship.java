package com.example.demo.scholarship;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties (value = { "hibernateLazyInitializer", "handler"})
@Table(name="scholarship")
public class scholarship {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
	    private Student student;

	@Column(name="amount")

	 private double amount;
 
	
		@Column(name="eligible")
		private boolean eligible;

		@Column(name="granted")

	 private String granted;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
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
	public String getGranted() {
		return granted;
	}
	public void setGranted(String granted) {
		this.granted = granted;
	}
	
	
	
	public scholarship() {
		super();
		// TODO Auto-generated constructor stub
	}
	public scholarship(Long id, Student student,double amount, String granted) {
		super();
		this.id = id;
		this.student = student;
		this.amount = amount;
		this.granted = granted;
	}
	@Override
	public String toString() {
		return "scholarship [id=" + id + ", student=" + student + ", amount=" + amount
				+ ", granted=" + granted + "]";
	}

	 
	 
	 
}
