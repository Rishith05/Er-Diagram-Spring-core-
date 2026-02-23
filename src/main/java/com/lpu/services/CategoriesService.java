package com.lpu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.CategoriesDao;
import com.lpu.entities.Categories;

@Component
public class CategoriesService {

    @Autowired
    private CategoriesDao dao;

    public void registerCategory(Categories c) {
        dao.saveCategory(c);
    }

    public Categories getCategory(int id) {
        Categories c = dao.findCategoryById(id);
        return c;
    }

    public void updateCategoryName(int id, String name) {
        dao.updateCategoryName(id, name);
    }

    public void deleteCategory(int id) {
        dao.deleteCategoryById(id);
    }
}