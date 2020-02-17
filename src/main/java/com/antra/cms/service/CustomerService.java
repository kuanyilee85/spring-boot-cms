// #6 Service Layer for CRUD
package com.antra.cms.service;

import com.antra.cms.dao.CustomerDAO;
import com.antra.cms.exception.CustomerNotFoundException;
import com.antra.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// use @Component to bind service layer (CustomerService) and api (CustomerResource)
@Component
public class CustomerService {

    // tell spring boot, I want to use CustomerDAO
    @Autowired
    private CustomerDAO customerDAO;

    // Create; POST /customers
    public Customer addCustomer(Customer customer){
        return customerDAO.save(customer);
    }

    // Read whole list of customer; GET /customers
    public List<Customer> getCustomer(){
        return customerDAO.findAll();
    }

    // Read specific customer; GET /customers/id
    public Customer getCustomer(int customerId){

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available...");
        return optionalCustomer.get();
    }

    // Update; PUT /customers/id
    public Customer updateCustomer(int customerId, Customer customer){
        return customerDAO.save(customer);
    }

    // Delete; DELETE /customers/id
    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }
}
