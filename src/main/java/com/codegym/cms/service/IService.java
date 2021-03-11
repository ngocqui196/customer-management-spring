package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<T> {

//    Page<Customer> findAllByFirstNameContaining(Pageable pageable);

    Iterable<T> findAll();


    T findById(Long Id);
    void update(T t);

    void save(T t);
    void remove(Long id);
}
