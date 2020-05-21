package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private Date dob;
	@Column(name="house_no")
	private int houseNo;
	private String street;
	private String city;
	private String district;
	private String state;
	private int pincode;
	@Column(name="is_valid")
	private boolean isValid;
	@Column(name="requesting_pahal")
	private boolean requestingPahal; 
	@Column(name="joined_pahal")
	private boolean joinedPahal;
	@Column(name="givedup_subsidy")
	private boolean isGivingUpSubsidy;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private Registration registration;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", district=" + district
				+ ", state=" + state + ", pincode=" + pincode + ", isValid=" + isValid + ", requestingPahal="
				+ requestingPahal + ", joinedPahal=" + joinedPahal + ", isGivingUpSubsidy=" + isGivingUpSubsidy
				+ ", registration=" + registration + "]";
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public boolean isRequestingPahal() {
		return requestingPahal;
	}
	public void setRequestingPahal(boolean requestingPahal) {
		this.requestingPahal = requestingPahal;
	}
	public boolean isJoinedPahal() {
		return joinedPahal;
	}
	public void setJoinedPahal(boolean joinedPahal) {
		this.joinedPahal = joinedPahal;
	}
	public boolean isGivingUpSubsidy() {
		return isGivingUpSubsidy;
	}
	public void setGivingUpSubsidy(boolean isGivingUpSubsidy) {
		this.isGivingUpSubsidy = isGivingUpSubsidy;
	}
	
	
	
	
}
