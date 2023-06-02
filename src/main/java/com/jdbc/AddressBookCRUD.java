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
            // Step 2: Update a contact (Update operation)
            updateContact(connection, 6, "Rohit", "Very", "Main street", "Gurgao", "Punjab", "323232", "+91 13323-4567", "Rohit.sam@example.com");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateContact(Connection connection, int id, String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) throws SQLException {
        String sql = "UPDATE address_book SET first_name=?, last_name=?, address=?, city=?, state=?, zip=?, phone=?, email=? WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, city);
            statement.setString(5, state);
            statement.setString(6, zip);
            statement.setString(7, phone);
            statement.setString(8, email);
            statement.setInt(9, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Contact not found or update failed.");
            }
        }
    }
}