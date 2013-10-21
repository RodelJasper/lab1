package com.example.alab1;

import java.io.Serializable;

public class Contact implements Serializable{
	
	private String firstName;
	private String surName;
	private String address;
	
	private String emailAdd;
	
	private String homeNumber;
	private String mobileNumber;
	private String workNumber;
	private String dob;
	
	Contact(String firstName, String surName, String address, String emailAdd, String homeNumber, String mobileNumber, String workNumber, 
			String dob){
		
		this.firstName = firstName;
		this.surName = surName;
		this.address = address;
		this.emailAdd = emailAdd;
		this.homeNumber = homeNumber;
		this.mobileNumber = mobileNumber;
		this.workNumber = workNumber;
		this.dob = dob;	
		
		
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getSurName(){
		return surName;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getEmail(){
		return emailAdd;
	}
	
	public String getHomeNum(){
		return homeNumber;
	}
	
	public String getMobileNum(){
		return mobileNumber;
	}
	
	public String getWorkNum(){
		return workNumber;
	}
	
	public String getDob(){
		return dob;
	}
	
}
