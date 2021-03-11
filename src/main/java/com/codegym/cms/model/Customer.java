package com.codegym.cms.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

@NotEmpty
@Size(min = 2,max = 30,message = "size 2-30")
@Email(regexp = "^(?=[a-z]*_*[a-z]*\\d_*)[a-z0-9]{6,20}@[a-z0-9]+(\\.[a-z0-9]+)$",
       message = "khong dung dinh dang email vui long nhap it nhat 1 ky tu so va do dai tu 6-20")
    private String firstName;
    private String lastName;

    @ManyToOne
    private Province province;

    public Customer() {
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    //    public Customer(Long id, String firstName, String lastName) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Customer.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Customer customer = (Customer) target;
//        String email = customer.getFirstName();
//        ValidationUtils.
//
//    }
}
