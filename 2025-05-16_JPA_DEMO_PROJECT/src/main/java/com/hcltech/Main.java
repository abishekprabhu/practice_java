package com.hcltech;

import com.hcltech.model.*;
import com.hcltech.util.dbUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntityManager em = dbUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // Create Profile
            Profile profile = new Profile();
            profile.setEmail("john.doe@example.com");
            profile.setMobile("9876543210");

            // Create Products
            Product product1 = new Product("Laptop", 75000.0);
            Product product2 = new Product("Mouse", 1500.0);

            // Create Order with Products
            Order order1 = new Order("Electronics Purchase");
            order1.setProductList(Arrays.asList(product1, product2));

            // Create User with Profile and Order
            User user = new User("John Doe", profile);
            order1.setUser(user); // Set bidirectional relationship
            user.setOrders(Arrays.asList(order1));

            // Persist the user (cascade will persist profile and orders, products)
            em.persist(user);

            transaction.commit();

            System.out.println("User and related entities saved successfully!");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            dbUtil.closeEntityManagerFactory();
        }
    }
}
