package com.hcltech;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("jpa-101");

    public static void main(String[] args) {

        new Main().go();
    }

    private void go() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
        final SessionFactory sessionFactory = new MetadataSources().buildMetadata().buildSessionFactory();
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        System.out.println(ENTITY_MANAGER_FACTORY);
    }
}