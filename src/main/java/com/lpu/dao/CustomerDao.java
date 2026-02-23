package com.lpu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entities.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class CustomerDao {

    @Autowired
    private EntityManagerFactory emf;

    public void saveCustomer(Customer c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(c);
        et.commit();
    }

    public Customer findCustomerById(int id) {
        EntityManager em = emf.createEntityManager();
        Customer c = em.find(Customer.class, id);
        em.close();
        return c;
    }

    public void updateCustomerEmail(int id, String email) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Customer c = em.find(Customer.class, id);

        et.begin();
        if (c != null) {
            c.setEmail(email);
            em.merge(c);
        }
        et.commit();
        em.close();
    }

    public void deleteCustomerById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Customer c = em.find(Customer.class, id);

        et.begin();
        if (c != null) em.remove(c);
        et.commit();
        em.close();
    }
}