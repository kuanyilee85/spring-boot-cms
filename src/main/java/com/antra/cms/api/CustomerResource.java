// #7 @PostMapping, #8 @GetMapping
package com.antra.cms.api;

import com.antra.cms.model.Customer;
import com.antra.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// when user hit the endpoint, the service Class trigger
@RequestMapping(value="/customers")
public class CustomerResource {

    // use @Autowired to inject business logic (methods) from service layer (CustomerService)
    @Autowired
    private CustomerService customerService;

    // CREATE API for user
    // @RequestBody allows user to pass customer jSON api to customerService
    // @PostMapping expose the method(customerService.addCustomer) to API
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer(customer);
    }

    // GET API return all user
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomer();
    }

    // GET API return single user by customerId
    @GetMapping(value="/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId){
        return customerService.getCustomer(customerId);
    }

    // PUT API update customer id and customer object
    @PutMapping(value="/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }
    @DeleteMapping(value="/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }
}
