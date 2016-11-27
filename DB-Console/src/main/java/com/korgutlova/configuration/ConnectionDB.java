package com.korgutlova.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionDB {
    private static Connection conn = null;
    private static String url;
    private static String username;
    private static String password;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                InputStream in = ConnectionDB.class
                        .getClassLoader().getResourceAsStream("persistence.properties");
                Properties properties = new Properties();
                properties.load(in);
                url = properties.getProperty("url");
                username = properties.getProperty("username");
                password = properties.getProperty("password");
            } catch (IOException ex) {
                exit(ex, "Failed to load properties!");
            }

            try {
                conn = DriverManager.getConnection(url, username, password);
                Statement statement = conn.createStatement();
            } catch (SQLException e) {
                exit(e, "Failed to get connection to the db!");
            }
        }
        return conn;
    }

    private static void exit(Exception e, String msg) {
        System.out.println(msg);
        e.printStackTrace();
        System.exit(1);
    }
}

