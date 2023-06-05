
package connectdatabase;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.*;

public class Database {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSV01";
    private static final String USER = "sa";
    private static final String PASSWORD = "1234";
    private static final DataSource dataSource = createDataSource();
    private static StudentDAO studentDAO;

    private static DataSource createDataSource() {
     
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        ds = new HikariDataSource( config );
        return new HikariDataSource(config);
    }
    public static Connection getConnection() throws SQLException  {
        studentDAO = new StudentDAOImpl(ds.getConnection());
        return ds.getConnection();
    }
    public static StudentDAO getStudentDAO() {
        return studentDAO;
    }
}