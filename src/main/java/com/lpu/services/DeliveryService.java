package com.lpu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.DeliveryDao;
import com.lpu.entities.Delivery;

@Component
public class DeliveryService {

    @Autowired
    private DeliveryDao dao;

    public void registerDelivery(Delivery d) {
        dao.saveDelivery(d);
    }

    public Delivery getDelivery(int id) {
        Delivery d = dao.findDeliveryById(id);
        if (d == null)
            throw new IllegalArgumentException("Delivery not found");
        return d;
    }

    public void updateStatus(int id, String status) {
        dao.updateDeliveryStatus(id, status);
    }

    public void deleteDelivery(int id) {
        dao.deleteDeliveryById(id);
    }
}