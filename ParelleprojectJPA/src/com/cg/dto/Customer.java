package com.cg.dto;

import javax.persistence.*;

@Entity
@Table(name="Customer_details")
public class Customer {
	@Column(name="c_name",length=10)
	private String cuName;
	@Id
	@Column(name="c_mob",length=10)
	private String cuMobileNo;
	@Column(name="c_age",length=5)
	private float cuAge;
	@Column(name="c_initbal",length=10)
	private double cuInitBalance;
	
	
	public String getCuName() {
		return cuName;
	}
	public void setCuName(String cuName) {
		this.cuName = cuName;
	}
	public String getCuMobileNo() {
		return cuMobileNo;
	}
	public void setCuMobileNo(String cuMobileNo) {
		this.cuMobileNo = cuMobileNo;
	}
	public float getCuAge() {
		return cuAge;
	}
	public void setCuAge(float cuAge) {
		this.cuAge = cuAge;
	}
	public double getCuInitBalance() {
		return cuInitBalance;
	}
	public void setCuInitBalance(double cuInitBalance) {
		this.cuInitBalance = cuInitBalance;
	}
	public Customer(String cuName, String cuMobileNo, float cuAge,
			double cuInitBalance) {
		super();
		this.cuName = cuName;
		this.cuMobileNo = cuMobileNo;
		this.cuAge = cuAge;
		this.cuInitBalance = cuInitBalance;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
