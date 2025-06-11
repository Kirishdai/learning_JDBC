package com.krish.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCDAODemo {
    public static void main(String[] args) throws Exception {

        // Create a DAO object and connect to the database
        UserDAO dao = new UserDAO();
        dao.connect();

        // Fetch and display the user with userid = 1
        User u1 = dao.getStudentById(1);
        System.out.printf("The user with userid %s is %s\n", u1.userid, u1.username);

        // Take user input for inserting new student record
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the username to insert into the database: ");
        String username = sc.nextLine();

        System.out.print("Enter the userid to insert into the database: ");
        int userid = sc.nextInt();

        // Insert new student using DAO method
        int count = dao.insertStudent(userid, username);
        System.out.printf("\nInserted username %s and userid %d into the database\n", username, userid);
        System.out.println("The number of rows affected: " + count);
    }
}

// DAO class responsible for all database operations
class UserDAO {

    Connection con;

    // Connects to MySQL database
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "Jayshreeram1#");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Fetches a user record based on userid
    public User getStudentById(int userid) throws Exception {
        User u = new User();
        String query = "SELECT username FROM student WHERE userid = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, userid);
        ResultSet rs = st.executeQuery();

        // Populate user object if result is found
        if (rs.next()) {
            u.userid = userid;
            u.username = rs.getString("username");
        } else {
            throw new Exception("User with userid " + userid + " not found.");
        }
        return u;
    }

    // Inserts a new user record into the student table
    public int insertStudent(int userid, String username) throws Exception {
        String query = "INSERT INTO student VALUES(?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, userid);
        st.setString(2, username);
        return st.executeUpdate();
    }
}

// POJO class to represent user data
class User {
    int userid;
    String username;
}
