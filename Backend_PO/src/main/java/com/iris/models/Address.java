package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Embeddable
@Table(name="tbl_address")
public class Address {
	
	
	@Column(name="houseNumber")
	@NotEmpty(message="house no can't be empty")
	private Integer houseNumber;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="city")
	@NotEmpty(message="city can't be empty")
	private String city;
	
	@Column(name="state")
	@NotEmpty(message="pincode can't be empty")
	private String state;
	
	@Column(name="pincode")
	@NotEmpty(message="pincode can't be empty")
	private Integer pincode;
	
	public Integer getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
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
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
}

