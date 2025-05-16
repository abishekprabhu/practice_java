package com.hcltech.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonRepository {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-101");
        }
        return entityManagerFactory;
    }
}
