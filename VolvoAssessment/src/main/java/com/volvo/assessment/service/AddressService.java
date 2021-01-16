package com.volvo.assessment.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volvo.assessment.model.Address;
import com.volvo.assessment.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {

        var it = addressRepository.findAll();

        var addresses = new ArrayList<Address>();
        it.forEach(e -> addresses.add(e));

        return addresses;
    }
    public void deleteById(Integer addressId) {

    	addressRepository.deleteById(addressId);
    }

    public void saveUpdate(Address address) {
    	addressRepository.save(address);
    }
    public List<Address> search(String zipcode) {
    	return addressRepository.findByZipCode(zipcode);    	    	
    }
}
