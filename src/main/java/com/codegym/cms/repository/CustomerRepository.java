package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
//    Page<Customer> findAllByFirstNameContaining( Pageable pageable);

}
