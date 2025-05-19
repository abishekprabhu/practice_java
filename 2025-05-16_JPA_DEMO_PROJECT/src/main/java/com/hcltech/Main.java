package com.hcltech;

import com.hcltech.model.Order;
import com.hcltech.model.Product;
import com.hcltech.model.Profile;
import com.hcltech.model.User;
import com.hcltech.util.dbUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //===========================================================
        EntityManager entityManager = dbUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        //===========================================================

        Profile profile = new Profile("Luffy@c.c","3724983274");
        User user = new User("Luffy", profile);

        Product product1 = new Product("Apple",40.0);
        Product product2 = new Product("Strawberry", 90.0);
        Order order = new Order("First Order");
        order.setProductList(Arrays.asList(product1,product2));

        user.setOrders(List.of(order));
        entityManager.persist(profile);
        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.clear();

        User fetched = entityManager.find(User.class, user.getId());
        System.out.println("USER FETCHED BY FIND ID :"+ fetched );
        entityManager.close();

    }
}