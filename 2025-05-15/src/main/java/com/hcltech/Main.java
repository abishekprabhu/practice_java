package com.hcltech;

import com.hcltech.model.Person;
import com.hcltech.service.PersonService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("jpa-101");

    public static void main(String[] args) {

        new Main().go();
    }

    private void EntityManager() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
        final SessionFactory sessionFactory = new MetadataSources().buildMetadata().buildSessionFactory();
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        System.out.println(ENTITY_MANAGER_FACTORY);
    }

    private void go(){
        final Person person=new Person("Suba",(short)24, Date.valueOf("2002-02-18"));
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myJpa");
        EntityManager manager=entityManagerFactory.createEntityManager();
//        manager.getTransaction().begin();
        manager.persist(person);
        manager.detach(person);
////        manager.detach(); - No need to delete the row
////        manager.find();
//        manager.getTransaction().commit();
//        manager.close();

//        EntityManager manager1=entityManagerFactory.createEntityManager();
//        manager1.getTransaction().begin();
//        Person person1=manager1.find(Person.class,2);
//        System.out.println(person1==null ? " No Person Found" : person1.toString());
//        manager1.getTransaction().commit();
//        manager1.close();

        PersonService personService=new PersonService();

        personService.create(new Person("Subi",(short)24, Date.valueOf("2001-02-18")));
        personService.create(new Person("Suji",(short)25, Date.valueOf("2000-02-18")));
        personService.create(new Person("Suba",(short)26, Date.valueOf("1999-02-18")));
        personService.create(new Person("Raja",(short)23, Date.valueOf("2002-02-18")));
//        System.out.println(personService.get());
//        personService.delete();
//        personService.get();


    }

    private void jahangir(){

    }
}


