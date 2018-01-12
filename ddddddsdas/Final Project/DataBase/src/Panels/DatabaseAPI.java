/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAPI {

    public Connection connection;

    public DatabaseAPI() throws SQLException, ClassNotFoundException {

        System.out.println("6ieb here?");
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
    }

    public void startConnection() throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/newGym", "root", "admin");

    }

    public ResultSet read(String sql) throws SQLException {
        startConnection();
        Statement statement = connection.createStatement();

        // Execute a statement
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(sql);
        return resultSet;
    }

    public int write(String sql) throws SQLException {
        startConnection();
        Statement statement = connection.createStatement();

        int x = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            x = rs.getInt(1);
        }
        connection.close();
        connection = null;
        return x;
    }

   

}
