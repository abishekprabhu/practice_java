package com.hcltech.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String HIKARI_CONFIG_FILE = "/hikari.properties";
    private static HikariDataSource HIKARI_DATA_SOURCE = null;

    private static HikariDataSource getDataSource(){
        if(HIKARI_DATA_SOURCE == null) {
            final HikariConfig hikariConfig = new HikariConfig(HIKARI_CONFIG_FILE);
            HIKARI_DATA_SOURCE = new HikariDataSource(hikariConfig);
        }
        return HIKARI_DATA_SOURCE;
    }

    public static Connection getConnection(){
        try {
            final Connection connection = getDataSource().getConnection();
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
