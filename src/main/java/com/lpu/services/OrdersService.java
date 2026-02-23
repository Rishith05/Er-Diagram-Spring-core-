package com.lpu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.OrdersDao;
import com.lpu.entities.Orders;

@Component
public class OrdersService {

    @Autowired
    private OrdersDao dao;

    public void createOrder(Orders o) {
        dao.saveOrder(o);
    }

    public Orders getOrder(int id) {
        Orders o = dao.findOrderById(id);
        if (o == null)
            throw new IllegalArgumentException("Order not found");
        return o;
    }

    public void updateOrderDate(int id, String date) {
        dao.updateOrderDate(id, date);
    }

    public void deleteOrder(int id) {
        dao.deleteOrderById(id);
    }
}