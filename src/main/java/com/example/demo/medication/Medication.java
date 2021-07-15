package com.example.demo.medication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medication")
public class Medication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="medication_id")
	private Long id;
	
	@Column(name="amount")
	private double amount;
	public Long getId() {
		return id;
	}
	public void setId(Long id2) {
		this.id = id2;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Medication(Long id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	public Medication() {

	}
	
	
	
	

}
