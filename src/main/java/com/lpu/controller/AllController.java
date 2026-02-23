package com.lpu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.config.MyConfig;
import com.lpu.entities.Categories;
import com.lpu.entities.Customer;
import com.lpu.entities.Delivery;
import com.lpu.entities.Orders;
import com.lpu.entities.Products;
import com.lpu.services.CategoriesService;
import com.lpu.services.CustomerService;
import com.lpu.services.DeliveryService;
import com.lpu.services.OrdersService;
import com.lpu.services.ProductsService;

public class AllController {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);

        CategoriesService categoryService = ac.getBean(CategoriesService.class);

        CustomerService customerService = ac.getBean(CustomerService.class);

        DeliveryService deliveryService = ac.getBean(DeliveryService.class);

        ProductsService productService = ac.getBean(ProductsService.class);

        OrdersService orderService = ac.getBean(OrdersService.class);
        
        
        // 1️ Category Operations
        Categories cat = new Categories();
        cat.setCategory_id(1);
        cat.setCategory_name("Electronics");
        cat.setCategory_type("Gadgets");

        categoryService.registerCategory(cat);
        categoryService.getCategory(1);
        
        
        // 2️ Customer Operations
        Customer customer = new Customer();
        customer.setCustomer_id(101);
        customer.setName("Rishith");
        customer.setEmail("rishith@gmail.com");
        customer.setAddress("Hyderabad");

        customerService.registerCustomer(customer);
        customerService.getCustomer(101);
        
        
        // 3️ Delivery Operations
        Delivery delivery = new Delivery();
        delivery.setDelivery_id(201);
        delivery.setType("Express");
        delivery.setStatus("Pending");

        deliveryService.registerDelivery(delivery);
        deliveryService.getDelivery(201);
  
        
        // 4️ Product Operations
        Products product = new Products();
        product.setProduct_id(301);
        product.setProduct_name("Laptop");
        product.setCategories(cat);

        productService.registerProduct(product);
        productService.getProduct(301);
                
        
        // 5️ Order Operations
        Orders order = new Orders();
        order.setOrder_id(401);
        order.setOrder_date("23-02-2026");
        order.setC(customer);
        order.setD(delivery);

        List<Products> productList = new ArrayList<>();
        productList.add(product);
        order.setProducts(productList);

        orderService.createOrder(order);
        orderService.getOrder(401);

        
        ac.close();
    }
}