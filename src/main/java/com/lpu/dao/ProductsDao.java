package com.lpu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entities.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class ProductsDao {

    @Autowired
    private EntityManagerFactory emf;

    public void saveProduct(Products p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.close();
    }

    public Products findProductById(int id) {
        EntityManager em = emf.createEntityManager();
        Products p = em.find(Products.class, id);
        em.close();
        return p;
    }

    public void updateProductName(int id, String name) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Products p = em.find(Products.class, id);
        p.setProduct_name(name);

        et.begin();
        em.merge(p);
        et.commit();
        em.close();
    }

    public void deleteProductById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Products p = em.find(Products.class, id);

        et.begin();
        em.remove(p);
        et.commit();
        em.close();
    }
}