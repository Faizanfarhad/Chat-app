package com.myapp.hellothere;

import java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistration {

    public boolean registerUser(String username, String hashedPassword) {
        String query = "INSERT INTO users (username, password_hash)  VALUES (?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}