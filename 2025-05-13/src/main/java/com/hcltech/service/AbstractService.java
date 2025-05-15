package com.hcltech.service;

import com.hcltech.model.Person;

import java.util.List;

public abstract class AbstractService<T> {
    public abstract List<T> getAllPerson();

    public abstract T getPersonById(int id);

    public abstract T createPerson(T t);

    public abstract T updatePerson(T t);

    public abstract void deletePersonById(final int id);
}
