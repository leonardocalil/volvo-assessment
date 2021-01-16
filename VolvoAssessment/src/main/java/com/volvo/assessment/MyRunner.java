package com.volvo.assessment;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.volvo.assessment.model.Address;
import com.volvo.assessment.model.Customer;
import com.volvo.assessment.model.User;
import com.volvo.assessment.repository.AddressRepository;
import com.volvo.assessment.repository.CustomerRepository;
import com.volvo.assessment.repository.UserRepository;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
   

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        logger.info("initializing users");

        var u1 = new User("Paul", "Smith", "paul.smith@gmail.com");
        userRepository.save(u1);

        var u2 = new User("Robert", "Black", "rb34@gmail.com");
        userRepository.save(u2);

        var u3 = new User("John", "Doe", "jdoe@gmail.com");
        userRepository.save(u3);
        
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
        /*
        var ca = new CustomerAddress(cust1, add1);
        ca = customerAddressRepository.save(ca);
        ca = new CustomerAddress(cust1, add2);
        customerAddressRepository.save(ca);
        ca = new CustomerAddress(cust2, add2);
        customerAddressRepository.save(ca);
        ca = new CustomerAddress(cust2, add3);
        customerAddressRepository.save(ca);
        */
        
    }
}
