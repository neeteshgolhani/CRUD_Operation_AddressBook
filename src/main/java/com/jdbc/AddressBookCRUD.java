package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressBookCRUD {
    // JDBC database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/address_book";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Neetesh@007";

    public static void main(String[] args) {
        // Step 1: Establish a database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            // Step 2: Create a new contact (Create operation)
            createContact(connection, "Rohit", "Sam", "Main Street", "Gurgao", "Pujab", "323232", "+91 13323-4567", "Rohit.sam@example.com");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createContact(Connection connection, String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) throws SQLException {
        String sql = "INSERT INTO address_book (first_name, last_name, address, city, state, zip, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,firstName);//firstname
            statement.setString(2, lastName);//lastname
            statement.setString(3, address);//address
            statement.setString(4, city);//city
            statement.setString(5, state);//state
            statement.setString(6, zip);//pincode
            statement.setString(7, phone);//contact
            statement.setString(8, email);//email

            statement.executeUpdate();

            System.out.println("Contact created successfully.");
        }
    }
}