package com.volvo.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.volvo.assessment.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
	
	//@Query("select c from Customer c join c.customer_address ca where ca.address_id.zipCode = ?1")
	@Query( value = "select * from customer c " +
            "join customer_address ca " +
            "   on c.document_id = ca.customer_id " +
            "join address a " +
            "   on ca.address_id = a.id " +
            "where a.zip_code = :zipcode", nativeQuery = true)
	List<Customer> getByZipcode(@Param("zipcode") String zipcode);
}
