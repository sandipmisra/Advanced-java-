package com.example.lab_task_2;
import org.apache.commons.dbcp2.BasicDataSource;
 
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
 
public class DBUtil {
 
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";
 
    private static final DataSource dataSource;
 
    static {
        try {
            dataSource = setupDataSource();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
 
    private static DataSource setupDataSource() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
        return ds;
    }
 
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}