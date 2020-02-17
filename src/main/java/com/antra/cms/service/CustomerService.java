// #6 Service Layer for CRUD
package com.antra.cms.service;

import com.antra.cms.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// use @Component to bind service layer (CustomerService) and api (CustomerResource)
@Component
public class CustomerService {

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    // Create; POST /customers
    public Customer addCustomer(Customer customer){
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return customer;
    }

    // Read whole list of customer; GET /customers
    public List<Customer> getCustomer(){
        return customerList;
    }

    // Read specific customer; GET /customers/id
    public Customer getCustomer(int customerId){
        return customerList
                .stream()
                .filter(c->c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }

    // Update; PUT /customers/id
    public Customer updateCustomer(int customerId, Customer customer){

        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId){
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }

    // Delete; DELETE /customers/id
    public void deleteCustomer(int customerId){
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId){
                        customerList.remove(c);
                    }
                });
    }
}
