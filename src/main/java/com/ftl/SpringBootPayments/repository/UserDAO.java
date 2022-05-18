package com.ftl.SpringBootPayments.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDAO  {
    private final String word = "REGISTRATION";
    public void insert(Connection connection, String[] user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO users (fio, email, phone) VALUES (?,?,?);");
            preparedStatement.setString(1, user[1]);
            preparedStatement.setString(2, user[2]);
            preparedStatement.setString(3, user[3]);
            preparedStatement.executeUpdate();


            preparedStatement.close();
            connection.commit();
        } catch (Exception e) {
            System.out.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        //LOG.log(Level.INFO, "Success insert into users table");
    }

    @Autowired
    public void readAll(Connection connection) {
        System.out.println();
        System.out.println("Users Table");
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select fio, email, phone from users");
            while (rs.next()) {
                System.out.printf("%-30s%-30s%-35s\n",
                        rs.getString("fio"),
                        rs.getString("email"),
                        rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //LOG.log(Level.INFO, "Success readAll from users table");
    }

    @Autowired
    public  Connection connection() {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "9090";
//        try {
//            DriverManager.registerDriver(new org.postgresql.Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
