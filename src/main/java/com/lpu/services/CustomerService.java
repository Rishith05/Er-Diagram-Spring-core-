package com.lpu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.CustomerDao;
import com.lpu.entities.Customer;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    public void registerCustomer(Customer c) {
        dao.saveCustomer(c);
    }

    public Customer getCustomer(int id) {
        Customer c = dao.findCustomerById(id);
        if (c == null)
            throw new IllegalArgumentException("Customer not found");
        return c;
    }

    public void updateEmail(int id, String email) {
        dao.updateCustomerEmail(id, email);
    }

    public void deleteCustomer(int id) {
        dao.deleteCustomerById(id);
    }
}