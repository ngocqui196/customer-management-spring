package com.codegym.cms.service.impl;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.CustomerRepository;
import com.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstName,Pageable pageable) {
        return repository.findAllByFirstNameContaining(firstName,pageable);
    }

//@Override
//    public Page<Customer> findAllByFirstNameContaining(Pageable pageable) {
//        return repository.findAllByFirstNameContaining(pageable);
//    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

//    @Override
//    public Iterable<Customer> findAll() {
//        return repository.findAll();
//    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return repository.findOne(id);

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }
}
