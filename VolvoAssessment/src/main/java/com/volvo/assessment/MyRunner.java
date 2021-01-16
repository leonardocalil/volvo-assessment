package com.volvo.assessment;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.volvo.assessment.model.Address;
import com.volvo.assessment.model.Customer;
import com.volvo.assessment.repository.AddressRepository;
import com.volvo.assessment.repository.CustomerRepository;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

     @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
   

    @Override
    @Transactional
    public void run(String... args) throws Exception {
    
        logger.info("initializing Address");
        
        var add1 = new Address("81130220", 10);
        add1 = addressRepository.save(add1);
        var add2 = new Address("80260300", 20);
        add2 = addressRepository.save(add2);
        var add3 = new Address("81180180", 30);
        add3 = addressRepository.save(add3);
        
        var cust1 = new Customer("311999000XX", "Leonardo Calil", 36);
        cust1.getAddresses().add(add1);
        cust1.getAddresses().add(add2);
        cust1 = customerRepository.save(cust1);
        
        var cust2 = new Customer("280000000XX", "Elias Davi", 36);
        cust2.getAddresses().add(add2);
        cust2.getAddresses().add(add3);
        cust2 = customerRepository.save(cust2);
      
        
    }
}
