// #13 data access object
package com.antra.cms.dao;

import com.antra.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// link dao<-->model by @Repository
@Repository
public interface CustomerDAO extends CrudRepository <Customer, Integer>{
}
