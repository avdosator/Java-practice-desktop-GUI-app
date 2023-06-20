package org.avdo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    Connection databaseConnection;
    PreparedStatement readStatement, updateStatement, deleteStatement, insertStatement;

    public static PersonDAO getInstance() {
        return PersonDAOHolder.instance;
    }

    private static class PersonDAOHolder {
        static PersonDAO instance = null;

        static {
            try {
                instance = new PersonDAO();
            } catch (SQLException e) {
                System.out.println("Connection was not created");
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    private PersonDAO() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/phonebook";
        String userName = "phonebook_user";
        String password = "phonebook_password";
        databaseConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/phonebook",
                "phonebook_user", "phonebook_password");
        readStatement = databaseConnection.prepareStatement("SELECT * FROM phonebook1 ORDER BY id");
        updateStatement = databaseConnection.prepareStatement("UPDATE phonebook1 SET phone_number = ? WHERE name=?");
        deleteStatement = databaseConnection.prepareStatement("DELETE FROM phonebook1 WHERE name = ? " +
                "AND surname = ?");
        insertStatement = databaseConnection.prepareStatement("INSERT INTO phonebook1 (name, surname, phone_number, city)" +
                "VALUES (?, ?, ?, ?)");

    }

    public List<Person> readFromDatabase() throws SQLException {
        List<Person> persons = new ArrayList<>();
        ResultSet resultSet = readStatement.executeQuery();
        while (resultSet.next()) {
            try {
                persons.add(new Person(resultSet.getString("id"),
                                       resultSet.getString("name"),
                                       resultSet.getString("surname"),
                                       resultSet.getString("phone_number"),
                                       resultSet.getString("city")));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return persons;
    }

    public int updateDatabase(String phoneNumber, String name) {
        int updatedRows = 0;
        try {
            updateStatement.setString(1, phoneNumber);
            updateStatement.setString(2, name);
            updatedRows = updateStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedRows;
    }

    public int deleteFromDatabase(String name, String surname) {
        int deletedRows = 0;
        try {
            deleteStatement.setString(1, name);
            deleteStatement.setString(2, surname);
            deletedRows = deleteStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ;
        }
        return deletedRows;
    }

    public int insertIntoDatabase(Person p) {
        int rowsInserted = 0;
        try {
            insertStatement.setString(1, p.getName());
            insertStatement.setString(2, p.getSurname());
            insertStatement.setString(3, p.getPhoneNumber());
            insertStatement.setString(4, p.getCity());
            rowsInserted = insertStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsInserted;
    }

    public void closeConnection() {
        if (databaseConnection != null) {
            try {
                databaseConnection.close();
            } catch (SQLException e) {
                System.out.println("Connection was not closed");
                System.out.println(e.getMessage());
            }
        }
    }
}
