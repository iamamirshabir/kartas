package com.example.demo.donation;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.example.demo.donor.Donor;


@Entity
@Table(name="donation")
public class Donation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="donation_id")
	private Long donation_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "donor_id")
	private Donor donor;
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="onday")
	private String onday;
	
	
	public Donation(Long donation_id, Donor donor, Long amount, String onday) {
		super();
		this.donation_id = donation_id;
		this.donor = donor;
		this.amount = amount;
		this.onday = onday;
	}
	
	

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Long getDonation_id() {
		return donation_id;
	}

	public void setDonation_id(Long donation_id) {
		this.donation_id = donation_id;
	}

	public Long getD_amount() {
		return amount;
	}

	public void setD_amount(Long amount) {
		this.amount = amount;
	}

	public String getD_onday() {
		return onday;
	}

	public void setD_onday(String onday) {
		this.onday = onday;
	}

	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Donation(Long donation_id, Long amount, String onday) {
		super();
		this.donation_id = donation_id;
		this.amount = amount;
		this.onday = onday;
	}

	

	@Override
	public String toString() {
		return "Donation [donation_id=" + donation_id + ", amount=" + amount + ", onday=" + onday + "]";
	}
	
	
	

}
