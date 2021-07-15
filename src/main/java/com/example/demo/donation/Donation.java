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
	
	@Column(name="d_amount")
	private Long d_amount;
	
	@Column(name="d_onday")
	private Long d_onday;
	
	
	public Donation(Long donation_id, Donor donor, Long d_amount, Long d_onday) {
		super();
		this.donation_id = donation_id;
		this.donor = donor;
		this.d_amount = d_amount;
		this.d_onday = d_onday;
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
		return d_amount;
	}

	public void setD_amount(Long d_amount) {
		this.d_amount = d_amount;
	}

	public Long getD_onday() {
		return d_onday;
	}

	public void setD_onday(Long d_onday) {
		this.d_onday = d_onday;
	}

	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Donation(Long donation_id, Long d_amount, Long d_onday) {
		super();
		this.donation_id = donation_id;
		this.d_amount = d_amount;
		this.d_onday = d_onday;
	}

	

	@Override
	public String toString() {
		return "Donation [donation_id=" + donation_id + ", d_amount=" + d_amount + ", d_onday=" + d_onday + "]";
	}
	
	
	

}
