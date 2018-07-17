package com.amro.model.DTO;

import java.util.Date;

public class Carrier {
	 private int id;
	 private String firstName;
	 private String lastName;
	 private String CompanyName;
	 private String phone;
	 private String email;
	 private String address;
	 private String city;
	 private String state;
	 private String zipcode;
	 private String federalId;
	 private String insurancePolicy;
	 private Date insuranceExpiration;
	 private Date dateCreated;
	
	 public Carrier() {
		 dateCreated = new Date();
		 insuranceExpiration = new Date();
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

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
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

	public String getFederalId() {
		return federalId;
	}

	public void setFederalId(String federalId) {
		this.federalId = federalId;
	}

	public String getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(String insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}

	public Date getInsuranceExpiration() {
		return insuranceExpiration;
	}

	public void setInsuranceExpiration(Date date) {
		this.insuranceExpiration = date;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getDispute() {
		return dispute;
	}

	public void setDispute(int dispute) {
		this.dispute = dispute;
	}

	private boolean active;
	 private int dispute;

	@Override
	public String toString() {
		return "Carrier [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", CompanyName="
				+ CompanyName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", federalId=" + federalId + ", insurancePolicy="
				+ insurancePolicy + ", insuranceExpiration=" + insuranceExpiration + ", dateCreated=" + dateCreated
				+ ", active=" + active + ", dispute=" + dispute + "]";
	}
	 
	 
	 
	 
	 
}
