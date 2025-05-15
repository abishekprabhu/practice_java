package com.hcltech.service;

import com.hcltech.model.Person;
import com.hcltech.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonService extends AbstractService<Person>{

    private static final String SELECT_ALL_QUERY = "SELECT * FROM PERSON";
    private static final String SELECT_ONE_PERSON_BY_ID = "SELECT * FROM PERSON WHERE ID=";

    @Override
    public List<Person> getAllPerson() {
         List<Person> result ;
         try(final Connection connection = DatabaseUtil.getConnection()){
          final ResultSet resultSet = connection.createStatement()
                  .executeQuery(SELECT_ALL_QUERY);
          result = resultSetToPersonsList(resultSet);
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
        return result;
    }


    @Override
    public Person getPersonById(final int id) {
        Person result ;
        try(final Connection connection = DatabaseUtil.getConnection()){
            final ResultSet resultSet = connection.createStatement()
                    .executeQuery(SELECT_ONE_PERSON_BY_ID+id);
            result = (Person) resultSetToPersonsList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Person createPerson(final Person person) {
        return null;
    }

    @Override
    public Person updatePerson(final Person person) {
        return null;
    }

    @Override
    public void deletePersonById(final int id) {

    }
    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------

    private List<Person> resultSetToPersonsList(ResultSet resultSet) throws SQLException {
        List<Person> result = new ArrayList<>();
        if(resultSet != null){
            while(resultSet.next()){
//                final Integer id = resultSet.getInt("id");
//                final String firstName = resultSet.getString("firstName");
//                final String lastName = resultSet.getString("lastName");
//                final Person person = new Person();
//                person.setId(id);
//                person.setFirstName(firstName);
//                person.setLastName(lastName);
//                result.add(person);
                result.add(new Person(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                ));
            }
        }
            return result;
    }


}
