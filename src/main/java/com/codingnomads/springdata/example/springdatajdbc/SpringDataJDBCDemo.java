/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.springdatajdbc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        try {
            jdbcTemplate.execute("CREATE TABLE customers (id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "first_name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Object[]> splitNames = Stream.of("Kelvin Rotich kelvin@gmail.com", "Naomi Clinton naomi@company.com",
                "John Doe doe@yahoo.com", "Mary Jane maryjane67@gmail.com")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        for (Object[] name : splitNames){
            jdbcTemplate.execute(String.format("INSERT INTO customers(first_name, last_name, email)" +
                    "VALUES ('%s','%s','%s')", name[0], name[1], name[2]));
        }

//        Query on customers out of the database
        Customer customers = jdbcTemplate.query("SELECT id, first_name, last_name, email " +
                "FROM customers WHERE last_name = 'Doe'",
                (result, row) -> new Customer(result.getLong("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"))).get(0);
        System.out.println(customers.toString());

//        Select multiple customers from the database
        jdbcTemplate.query("SELECT id, first_name, last_name, email" +
                " FROM customers",
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email")))
                .forEach(customer -> System.out.println(customer.toString()));

        //Query the database to get the first_name of the customer with id = 2
        String name = jdbcTemplate.queryForObject("SELECT first_name FROM customers " +
                "WHERE id = 2", String.class);
        System.out.println("Name is: " + name);

//        try {
//            // create employee table using the JdbcTemplate method "execute"
//            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY,"
//                    + "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");
//        } catch (Exception e) {
//            // nothing
//        }
//
//        // create a list of first and last names
//        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
//                .map(name -> name.split(" "))
//                .collect(Collectors.toList());
//
//        // for each first & last name pair insert an Employee into the database
//        for (Object[] name : splitUpNames) {
//            jdbcTemplate.execute(
//                    String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
//        }
//
//        // query the database for Employees with first name Java
//        jdbcTemplate
//                .query(
//                        "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
//                        (rs, rowNum) ->
//                                new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
//                // print each found employee to the console
//                .forEach(employee -> System.out.println(employee.toString()));

//         truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE customers;");
        // delete the table
        jdbcTemplate.execute("DROP TABLE customers");
    }
}
