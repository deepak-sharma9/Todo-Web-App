package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc_connection {

    private static final String url="jdbc:mysql://localhost:3306/todo";
    private static final String user="root";
    private static final String pass="deepak123";

    private static Connection connection;
    public static Connection getConnection()   {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return connection;
    }

}
