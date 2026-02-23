package com.lpu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.ProductsDao;
import com.lpu.entities.Products;

@Component
public class ProductsService {

    @Autowired
    private ProductsDao dao;

    public void registerProduct(Products p) {
        dao.saveProduct(p);
    }

    public Products getProduct(int id) {
        Products p = dao.findProductById(id);
        if (p == null)
            throw new IllegalArgumentException("Product not found");
        return p;
    }

    public void updateProductName(int id, String name) {
        dao.updateProductName(id, name);
    }

    public void deleteProduct(int id) {
        dao.deleteProductById(id);
    }
}