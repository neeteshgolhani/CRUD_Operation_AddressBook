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
            // Step 2: Delete a contact (Delete operation)
            deleteContact(connection, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteContact(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM address_book WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Contact not found or delete failed.");
            }
        }
    }
}
