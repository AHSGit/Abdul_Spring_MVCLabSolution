package com.greatlearning.studentManagement.model;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

//entity class to create the table 
@Entity
@Table
public class Student {

	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;

	// columns
	@Column
	private String name;

	@Column
	private String department;

	@Column
	private String country;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", Name=" + name + ", Department=" + department + ", Country="
				+ country + "]";
	}

}
