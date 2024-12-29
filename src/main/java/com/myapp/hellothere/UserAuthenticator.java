package com.myapp.hellothere;


import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthenticator {
    public boolean authenticate(String username, String password) throws SQLException {
        String query = "SELECT password_hash FROM users WHERE username = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                String storedHash = resultSet.getString("password_hash");
                return  PasswordUtils.verifyPassword(password, storedHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return false;
    }

}
