package com.jdbc;

import java.sql.*;

public class AddressBookCRUD {
    // JDBC database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/address_book";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Neetesh@007";

    public static void main(String[] args) {
        // Step 1: Establish a database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            // Step 2: Retrieve contacts (Read operation)
            retrieveContacts(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void retrieveContacts(Connection connection) throws SQLException {
        String sql = "SELECT * FROM address_book";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Contacts:");
            while (resultSet.next()) {
                // Retrieve the data for each contact from the ResultSet

                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zip = resultSet.getString("zip");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                // Print the details of each contact

                System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName + ", Address: " + address + ", City: " + city + ", State: " + state + ", Zip: " + zip + ", Phone: " + phone + ", Email: " + email);
            }
        }
    }
}