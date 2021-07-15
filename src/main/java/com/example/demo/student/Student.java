package com.example.demo.student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.scholarship.scholarship;

@Entity
@Table(name="student")
public class Student {

	@Id
	@Column(name="student_id")
	private Long student_id;
	
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "student")
	private scholarship scholarship;
	
	@Column(name="student_name")
	private int student_name;
	
	@Column(name="student_rollno")
	private int student_rollno;
	
	@Column(name="student_dob")
	private int student_dob;
	
	@Column(name="student_semester")
	private int student_semester;
	
	@Column(name="student_institute")
	private int student_institute;
	
	@Column(name="student_mobile")
	private int student_mobile;
	
	@Column(name="student_email")
	private int student_email;

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public int getStudent_name() {
		return student_name;
	}

	public void setStudent_name(int student_name) {
		this.student_name = student_name;
	}

	public int getStudent_rollno() {
		return student_rollno;
	}

	public void setStudent_rollno(int student_rollno) {
		this.student_rollno = student_rollno;
	}

	public int getStudent_dob() {
		return student_dob;
	}

	public void setStudent_dob(int student_dob) {
		this.student_dob = student_dob;
	}

	public int getStudent_semester() {
		return student_semester;
	}

	public void setStudent_semester(int student_semester) {
		this.student_semester = student_semester;
	}

	public int getStudent_institute() {
		return student_institute;
	}

	public void setStudent_institute(int student_institute) {
		this.student_institute = student_institute;
	}

	public int getStudent_mobile() {
		return student_mobile;
	}

	public void setStudent_mobile(int student_mobile) {
		this.student_mobile = student_mobile;
	}

	public int getStudent_email() {
		return student_email;
	}

	public void setStudent_email(int student_email) {
		this.student_email = student_email;
	}

	public Student() {
		super();
		
	}

	public Student(Long student_id, com.example.demo.scholarship.scholarship scholarship, int student_name,
			int student_rollno, int student_dob, int student_semester, int student_institute, int student_mobile,
			int student_email) {
		super();
		this.student_id = student_id;
		this.scholarship = scholarship;
		this.student_name = student_name;
		this.student_rollno = student_rollno;
		this.student_dob = student_dob;
		this.student_semester = student_semester;
		this.student_institute = student_institute;
		this.student_mobile = student_mobile;
		this.student_email = student_email;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", scholarship=" + scholarship + ", student_name=" + student_name
				+ ", student_rollno=" + student_rollno + ", student_dob=" + student_dob + ", student_semester="
				+ student_semester + ", student_institute=" + student_institute + ", student_mobile=" + student_mobile
				+ ", student_email=" + student_email + "]";
	}
	
	
	
	
	
	
	
	
}
