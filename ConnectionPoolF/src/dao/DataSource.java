package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static DataSource instance;
    private HikariDataSource dataSource;

    private DataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=QLSV01");
        config.setUsername("sa");
        config.setPassword("1234");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=QLSV01");
            config.setUsername("sa");
            config.setPassword("1234");
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(5);
            config.setIdleTimeout(30000);
            config.setMaxLifetime(1800000);
            dataSource = new HikariDataSource(config);
        }
        return dataSource.getConnection();
    }
}
