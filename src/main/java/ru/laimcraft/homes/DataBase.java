package ru.laimcraft.homes;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBase {

    // Нужно добавить настройку параметров в config.yml в будущем

    public static HikariDataSource dataSource;

    public static void init() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://127.0.0.1/?");
        config.setUsername("laimcraft");
        config.setPassword("rrttyyuu");

        // Настройка пула соединений
        config.setMaximumPoolSize(100);
        config.setMinimumIdle(100);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close() {
        if (dataSource != null) dataSource.close();
    }

}
