package com.company.connection;

import com.company.Configuration;

import java.sql.*;
import java.util.Properties;


public class Connect {
    static private Connection CONNECTION;

    //String url = "jdbc:postgresql://localhost/test";
    //String user = "postrgres";
    //String password = "zbynio";


    public static void connect() throws SQLException{
        Properties props = new Properties();
        props.setProperty("user", Configuration.USER);
        props.setProperty("password", Configuration.PASS);
        CONNECTION = DriverManager.getConnection(Configuration.DB_URL, props);
        System.out.println("connected");

    }

    public static Statement getStatement() throws SQLException {
        return CONNECTION.createStatement();
    }

    public static ResultSet executeSQL(String sql) throws SQLException{
        CONNECTION.createStatement().execute(sql);
        return null;
    }







}
