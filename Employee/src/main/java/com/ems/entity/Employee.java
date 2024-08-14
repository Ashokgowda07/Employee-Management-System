package com.ems.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String Image;
	
	private String Name;
	
	private String Email;
	
	private long mobile_no;
	
	private String Designation;
	
	private String Gender;
	
	private String Course;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreateDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createdate) {
		CreateDate = createdate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Image=" + Image + ", Name=" + Name + ", Email=" + Email + ", mobile_no="
				+ mobile_no + ", Designation=" + Designation + ", Gender=" + Gender + ", Course=" + Course
				+ ", CreateDate=" + CreateDate + "]";
	}

	
	

}
