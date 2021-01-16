package com.volvo.assessment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String zipCode;
	private Integer number;

    
    public Address() {    	
    }

    

	public Address(String zipCode, Integer number) {
		super();
		this.zipCode = zipCode;
		this.number = number;
	}
	public Address(Address address) {
		super();
		this.id = address.getId();
		this.zipCode = address.getZipCode();
		this.number = address.getNumber();
	}
	



	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}
    

	


	

    
    


    

}
