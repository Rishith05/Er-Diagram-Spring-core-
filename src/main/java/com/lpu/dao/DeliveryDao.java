package com.lpu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entities.Delivery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class DeliveryDao {

    @Autowired
    private EntityManagerFactory emf;

    public void saveDelivery(Delivery d) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(d);
        et.commit();
        em.close();
    }

    public Delivery findDeliveryById(int id) {
        EntityManager em = emf.createEntityManager();
        Delivery d = em.find(Delivery.class, id);
        em.close();
        return d;
    }

    public void updateDeliveryStatus(int id, String status) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Delivery d = em.find(Delivery.class, id);
        d.setStatus(status);

        et.begin();
        em.merge(d);
        et.commit();
        em.close();
    }

    public void deleteDeliveryById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Delivery d = em.find(Delivery.class, id);

        et.begin();
        em.remove(d);
        et.commit();
        em.close();
    }
}