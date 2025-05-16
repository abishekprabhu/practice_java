package com.hcltech.service;

import com.hcltech.model.Person;
import com.hcltech.util.PersonRepository;
import jakarta.persistence.EntityManager;

public class PersonService {

    public String get(){
        Person person;
        EntityManager manager = PersonRepository.getEntityManagerFactory().createEntityManager();

        manager.getTransaction().begin();
        person=manager.find(Person.class,1);
        manager.getTransaction().commit();
        manager.close();
        return person==null ? "No Person Details found" : person.toString();
    }

    public void delete(){
        Person person;
        EntityManager manager = PersonRepository.getEntityManagerFactory().createEntityManager();

        manager.getTransaction().begin();
        person=manager.find(Person.class,1);
        if(person != null) {
            manager.remove(person);
        }
        System.out.println("Person not found");
        manager.getTransaction().commit();
        manager.close();
    }

    public void  create(Person person){
        EntityManager manager=PersonRepository.getEntityManagerFactory().createEntityManager();
        manager.getTransaction().begin();
        manager.persist(person);
        manager.getTransaction().commit();
        manager.close();
        System.out.println("Person added successfully");
    }

    public Person updateById(int id){
        Person person;
        EntityManager manager=PersonRepository.getEntityManagerFactory().createEntityManager();
        manager.getTransaction().begin();
        person=manager.find(Person.class,id);
        manager.getTransaction().commit();
        manager.close();
        return person;
    }

}
