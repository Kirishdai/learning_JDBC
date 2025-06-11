package com.krish.jdbc;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {

        // Load and register the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Define the connection URL, username, and password
        String url = "jdbc:mysql://localhost:3306/aliens?allowMultipleQueries=true";
        String uname = "root";
        String pass = "Jayshreeram1#";

        // Define the SQL query using placeholders for parameterized input
        String query = "INSERT INTO student VALUES (?, ?)";

        // Sample input data to be inserted
        int userid = 5;
        String username = "Krish";

        // Establish connection to the database
        Connection con = DriverManager.getConnection(url, uname, pass);

        // Create a PreparedStatement object to safely insert values
        PreparedStatement ps = con.prepareStatement(query);

        // Bind values to the query placeholders
        ps.setInt(1, userid);
        ps.setString(2, username);

        // Execute the query and get the number of rows affected
        int count = ps.executeUpdate();

        // Output the result
        System.out.println(count + " row/rows affected");

        // Close resources to avoid memory leaks
        ps.close();
        con.close();
    }
}
