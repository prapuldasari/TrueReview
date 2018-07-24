package utility;

import java.sql.*;

public class ConnectionPool {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String dbName = "reviewsdata";
        String userName = "root";
        String password = "rootroot";
        String hostname = "reviewsdata.ckjq05jddzwc.us-west-2.rds.amazonaws.com";
        String port = "3306";
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
        return DriverManager.getConnection(jdbcUrl);
    }
}
