package org.avdo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        PersonDAO personDAO = PersonDAO.getInstance();

        //personDAO.updateDatabase("062123457", "Azra");

        //int a = personDAO.deleteFromDatabase("Dinka", "Sator");
        //System.out.println("Deleted " + a + " rows");
        List<Person> personList = null;
        try {
            personList = personDAO.readFromDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        serialize(personList);

        personDAO.closeConnection();
    }

    private static void serialize(List<Person> personList) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        try {
            objectWriter.writeValue(new File("src/main/resources/person.json"), personList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}