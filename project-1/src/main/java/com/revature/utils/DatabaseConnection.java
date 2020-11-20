package com.revature.utils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
    private static final Logger logger = LogManager.getLogger(DatabaseConnection.class);
    private static DatabaseConnection db = null;
    private static Connection connection;

    private DatabaseConnection() {
        String URL = "jdbc:postgresql://"+System.getenv("RDS_DATABASE_NAME")+"/";
        String USER = System.getenv("RDS_SERVER_USERNAME");
        String PASS = System.getenv("RDS_SERVER_PASSWORD");
        Properties properties = new Properties();
        properties.setProperty("user",USER);
        properties.setProperty("password",PASS);

        System.out.print("Connecting to SQL Server ... ");
        try {
            connection = DriverManager.getConnection(URL,properties);

            System.out.println("Done.");

        } catch (Exception e) {
            System.err.println("Could not connect");
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getConnection() {
        if (db == null) {
            db = new DatabaseConnection();
            logger.trace("A new database connection was created ");
        }
        return db;
    }
}
