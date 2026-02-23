package com.lpu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entities.Orders;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class OrdersDao {

    @Autowired
    private EntityManagerFactory emf;

    public void saveOrder(Orders o) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(o);
        et.commit();
        em.close();
    }

    public Orders findOrderById(int id) {
        EntityManager em = emf.createEntityManager();
        Orders o = em.find(Orders.class, id);
        em.close();
        return o;
    }

    public void updateOrderDate(int id, String date) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Orders o = em.find(Orders.class, id);
        o.setOrder_date(date);

        et.begin();
        em.merge(o);
        et.commit();
        em.close();
    }

    public void deleteOrderById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Orders o = em.find(Orders.class, id);

        et.begin();
        em.remove(o);
        et.commit();
        em.close();
    }
}