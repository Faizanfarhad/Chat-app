package com.myapp.hellothere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static  final String URL = "jdbc:mysql://localhost:3307/chatapp_db";
    private static final String  USER = "root";
    private  static  final  String PASSWORD = "faizan@21";

    public  static  Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
