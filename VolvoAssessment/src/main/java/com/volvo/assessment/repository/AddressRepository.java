package com.volvo.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.volvo.assessment.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
	List<Address> findByZipCode(String zipCode);
}
