package com.pablo.autogest.DAO;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final HikariDataSource ds;

    static {
        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/oficina");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    private ConnectionPool() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
