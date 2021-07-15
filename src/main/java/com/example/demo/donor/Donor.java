package com.example.demo.donor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.donation.Donation;


@Entity
@Table(name="donor")
public class Donor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="donor_id")
	private Long donor_id;
	
@OneToMany(mappedBy = "donor", cascade = {
        CascadeType.ALL
    })
    private List < Donation > donation;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="amount")
	private double amount;

	public Long getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(Long id) {
		this.donor_id = id;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	
	
	public Donor() {
		super();
	}

	public Donor(Long donor_id, String name, String email, String mobile, double amount) {
		super();
		this.donor_id = donor_id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Donor [donor_id=" + donor_id + ", first_name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	

}
