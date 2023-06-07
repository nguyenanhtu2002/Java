package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
public class DataSource {

    private static DataSource instance;
 //   private HikariDataSource dataSource;
    private static HikariDataSource ds;
     private static DataSource dataSource;

    private DataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=QLSV01");
        config.setUsername("sa");
        config.setPassword("1234");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        ds = new HikariDataSource(config);
    }

//    public static DataSource getInstance() {
//        if (instance == null) {
//            instance = new DataSource();
//        }
//        return instance;
//    }

    public static DataSource getInstance() {
        if (Objects.isNull(dataSource)) {
            dataSource = new DataSource();
        }
        return dataSource;
    }
        public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
