package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class HikariSetUp {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.setDriverClassName("org.postgresql.Driver");

        config.setMaximumPoolSize(10);
        config.setConnectionTestQuery("SELECT 1");

        HikariDataSource ds = new HikariDataSource(config);

        try (Connection connection = ds.getConnection()) {
            System.out.println("Successfully connected to the database using HikariCP!");

            Statement statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS emp (id SERIAL PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))";
            statement.execute(createTableSQL);
            System.out.println("Table 'emp' created!");

            String insertSQL = "INSERT INTO emp (name, email) VALUES ('John Doe', 'john.doe@example.com')";
            statement.executeUpdate(insertSQL);
            System.out.println("Inserted data into 'emp' table!");

            String selectSQL = "SELECT * FROM emp";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()) {
                System.out.println("Emp ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Email: " + resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}