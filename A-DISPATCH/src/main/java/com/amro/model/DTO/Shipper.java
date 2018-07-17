package com.amro.model.DTO;

import java.util.Date;

public class Shipper {
	 private int id;
	 private String firstName;
	 private String lastName;
	 private String phone;
	 private String email;
	 private String address;
	 private String city;
	 private String state;
	 private String zipcode;
	 private boolean active;
	 private Date date;
	 private int dispute;
	 
	 public Shipper() {
		 date = new Date();
	 }

	public Date getDate() {
		return date;
	}

	public int getDispute() {
		return dispute;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDispute(int dispute) {
		this.dispute = dispute;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public void setActive(boolean status) {
		this.active = status;
	}
	
	public boolean getActive() {
		return active;
	}

	@Override
	public String toString() {
		return "Shipper [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", active=" + active + ", date=" + date + ", dispute=" + dispute + "]";
	}

	 
	 

}
