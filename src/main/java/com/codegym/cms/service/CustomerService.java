package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService extends IService<Customer>{
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
    //    Page<Customer> findAllByFirstNameContaining(String firstName,Pageable pageable);
////    Page<Customer> findAllByFirstNameContaining(Pageable pageable);
//
//
//    Page<Customer> findAll(Pageable pageable);
//
////    Iterable<Customer> findAll();
//    Customer findById(Long Id);
//    void save(Customer customer);
//    void remove(Long id);
}
