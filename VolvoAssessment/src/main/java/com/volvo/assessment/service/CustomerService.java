package com.volvo.assessment.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volvo.assessment.model.Address;
import com.volvo.assessment.model.Customer;
import com.volvo.assessment.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {

        var it = customerRepository.findAll();
        return format(it);	
     
    }
    private List<Customer> format(Iterable<Customer> it) {
    	var customers = new ArrayList<Customer>();
        for(Customer c : it) {
        	Customer customer = new Customer(c);
        	Set<Address> addresses = c.getAddresses();
        	for(Address a : addresses) {
        		Address address = new Address(a);
        		address.setZipCode(zipCodeMask(address.getZipCode()));
        		customer.getAddresses().add(address);
        	}
        	customers.add(customer);
        }
       
        return customers;
    }
    public void deleteById(String documentId) {

    	customerRepository.deleteById(documentId);
    }

    public void saveUpdate(Customer customer) {
    	customerRepository.save(customer);
    }
    public List<Customer> search(String zipcode) {
    	var it = customerRepository.getByZipcode(zipcode);
    	return format(it);    	
    }
    
    private String zipCodeMask(String zipCode) {
    	StringBuilder sb = new StringBuilder(zipCode);
    	if(sb.length() > 3) {
    		sb.insert(sb.length()-3, "-");
    	}
    	return sb.toString();
    }
}
