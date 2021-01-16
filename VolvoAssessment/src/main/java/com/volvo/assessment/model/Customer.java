package com.volvo.assessment.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

    @Id
    private String documentId;
    private String name;
    private Integer age;
    private Date registrationDate;
    private Date lastUpdateInfo;
    @ManyToMany
    @JoinTable(name = "customer_address", 
    		joinColumns = { @JoinColumn(name = "customer_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "address_id") })
    private Set<Address> addresses = new HashSet<>();

    public Customer() {
    	this.registrationDate = Calendar.getInstance().getTime();
    }

    
   
    public Customer(String documentId, String name, Integer age) {
		super();
		this.documentId = documentId;
		this.name = name;
		this.age = age;
		this.registrationDate = Calendar.getInstance().getTime();
	}
    
    public Customer(Customer customer) {
		super();
		this.documentId = customer.getDocumentId();
		this.name = customer.getName();
		this.age = customer.getAge();
		this.registrationDate = customer.getRegistrationDate();
		this.lastUpdateInfo = customer.getLastUpdateInfo();
	}



	public String getDocumentId() {
		return documentId;
	}



	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Date getRegistrationDate() {
		return registrationDate;
	}



	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}



	public Date getLastUpdateInfo() {
		return lastUpdateInfo;
	}



	public void setLastUpdateInfo(Date lastUpdateInfo) {
		this.lastUpdateInfo = lastUpdateInfo;
	}



	public Set<Address> getAddresses() {
		return addresses;
	}



	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	
}
