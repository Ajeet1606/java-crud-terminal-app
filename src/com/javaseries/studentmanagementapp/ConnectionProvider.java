package com.javaseries.studentmanagementapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    static Connection connection;

    public static Connection createConnection(){
        try {
//            load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
//            create the connection
            String user = "root";
            String password = System.getenv("password");
            String url = "jdbc:mysql://localhost:3306/student_management?useSSL=false";
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
