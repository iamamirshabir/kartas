package com.example.demo.student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.scholarship.scholarship;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
	private Long student_id;
	
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "student")
	private scholarship scholarship;
	
	@Column(name="student_name")
	private String student_name;
	
	@Column(name="student_rollno")
	private String student_rollno;
	
	@Column(name="student_dob")
	private String student_dob;
	
	@Column(name="student_semester")
	private int student_semester;
	
	@Column(name="student_institute")
	private String student_institute;
	
	@Column(name="student_mobile")
	private String student_mobile;
	
	@Column(name="student_email")
	private String student_email;

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_rollno() {
		return student_rollno;
	}

	public void setStudent_rollno(String student_rollno) {
		this.student_rollno = student_rollno;
	}

	public String getStudent_dob() {
		return student_dob;
	}

	public void setStudent_dob(String student_dob) {
		this.student_dob = student_dob;
	}

	public int getStudent_semester() {
		return student_semester;
	}

	public void setStudent_semester(int student_semester) {
		this.student_semester = student_semester;
	}

	public String getStudent_institute() {
		return student_institute;
	}

	public void setStudent_institute(String student_institute) {
		this.student_institute = student_institute;
	}

	public String getStudent_mobile() {
		return student_mobile;
	}

	public void setStudent_mobile(String student_mobile) {
		this.student_mobile = student_mobile;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public Student() {
		super();
		
	}


	public Student(Long student_id, com.example.demo.scholarship.scholarship scholarship, String student_name,
			String student_rollno, String student_dob, int student_semester, String student_institute,
			String student_mobile, String student_email) {
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
