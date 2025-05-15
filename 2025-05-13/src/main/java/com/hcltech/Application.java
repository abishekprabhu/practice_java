package com.hcltech;

import com.hcltech.model.Person;
import com.hcltech.service.AbstractService;
import com.hcltech.service.PersonService;

import java.util.List;
import java.util.Scanner;

public class Application {

//    private final PersonService personService = new PersonService();
    private final AbstractService<Person> abstractService = new PersonService();
    public static void main(String[] args) {

        new Application().go();
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER THE ID : ");
        int id = scanner.nextInt();
        new Application().findById(id);

    }

    private void go(){
        final List<Person> allPersons = abstractService.getAllPerson();
        System.out.println(allPersons);
    }

    private void findById(int id){
        Person findPersonById = abstractService.getPersonById(id);
        System.out.println(findPersonById);
    }

}
