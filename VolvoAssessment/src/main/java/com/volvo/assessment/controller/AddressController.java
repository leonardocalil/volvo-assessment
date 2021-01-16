package com.volvo.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volvo.assessment.model.Address;
import com.volvo.assessment.service.AddressService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    
    
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Return all addresses"),
    	    @ApiResponse(code = 403, message = "You are not allowed to access this resource"),
    	    @ApiResponse(code = 500, message = "Internal server error"),
    	})
    @GetMapping("/all")
    public List<Address> all() {

        return addressService.findAll();
    }
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Return list of addresses searched by zipCode"),
    	    @ApiResponse(code = 403, message = "You are not allowed to access this resource"),
    	    @ApiResponse(code = 500, message = "Internal server error"),
    	})
    @GetMapping("/search/{zipcode}")
    public List<Address> search(@PathVariable String zipcode ) {

        return addressService.search(zipcode);
    }
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Save and update the address. Return 'DONE' if OK"),
    	    @ApiResponse(code = 403, message = "You are not allowed to access this resource"),
    	    @ApiResponse(code = 500, message = "Internal server error"),
    	})
    @PostMapping("/saveUpdate")
    public String save(@RequestBody Address address) {
    	addressService.saveUpdate(address);
        return "DONE";
    }
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Delete the address by its ID. Return 'DONE' if OK"),
    	    @ApiResponse(code = 403, message = "You are not allowed to access this resource"),
    	    @ApiResponse(code = 500, message = "Internal server error"),
    	})
    @DeleteMapping("/delete/{addressId}")
    public String delete(@PathVariable Integer addressId) {
    	addressService.deleteById(addressId);
    	return "DONE";
    }
}