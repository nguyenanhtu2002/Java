package database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.beans.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
public class JDBCUtil {

    public static Connection getConnection() {
        Connection c =null;
        var server = "LAPTOP-F55BCDK3";
        var user = "sa";
        var password = "1234";
        var db = "QLSV01";
        var port = 1433;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        try (Connection conn = ds.getConnection()) {
            System.out.println("Success");
            System.out.println(conn.getCatalog());
            c = ds.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


