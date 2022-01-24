package com.tqtplayer.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private String jdbcURLFormat = "jdbc:mysql://localhost:3306/%s?useSSL=false&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "tientran123@";
    private String databaseName;
    private static MysqlConnection instance;
    
    private MysqlConnection() {

    }


    public static MysqlConnection getInstance() {
        if (instance == null)
            instance = new MysqlConnection();
        return instance;
    }

    public static void init(String databaseName) {
        getInstance().databaseName = databaseName;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(String.format(jdbcURLFormat, databaseName), jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
