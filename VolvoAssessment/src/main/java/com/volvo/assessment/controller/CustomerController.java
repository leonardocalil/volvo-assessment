package com.volvo.assessment.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volvo.assessment.model.Customer;
import com.volvo.assessment.service.CustomerService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Return all Customers and their addresses"),
    	})
    @GetMapping("/all")
    public List<Customer> all() {

        return customerService.findAll();
    }
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Return list of customers searched by zipCode"),
    	    @ApiResponse(code = 403, message = "You are not allowed to access this resource"),
    	    @ApiResponse(code = 500, message = "Internal server error"),
    	})
    @GetMapping("/search/{zipcode}")
    public List<Customer> search(@PathVariable String zipcode ) {

        return customerService.search(zipcode);
    }
    
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Save and update the customer. Return 'DONE' if OK"),
    	    @ApiResponse(code = 403, message = "You are not allowed to access this resource"),
    	    @ApiResponse(code = 500, message = "Internal server error"),
    	})
    @PostMapping("/saveUpdate")
    public String save(@RequestBody Customer customer) {
        customerService.saveUpdate(customer);
        return "DONE";
    }    
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Delete the customer by its DocumentId. Return 'DONE' if OK"),
    	    @ApiResponse(code = 403, message = "You are not allowed to access this resource"),
    	    @ApiResponse(code = 500, message = "Internal server error"),
    	})
    @DeleteMapping("/delete/{documentId}")
    public String delete(@PathVariable String documentId) {
    	customerService.deleteById(documentId);
    	return "DONE";
    }
}