package com.josh.miniproject.atm.Atm.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection connection = null;

    public static Connection openConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Jeevan", "postgres", "123456");
        return connection;
    }

    public static void closeConnection() throws Exception {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

