package com.dbconchecker.services;

import com.dbconchecker.Beans.DataBaseConfig;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Service
public class DatabaseConnectionService {

    public boolean checkConnection(DataBaseConfig config) {
        DataSource dataSource = createDataSource(config);
        try (Connection connection = dataSource.getConnection()) {
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private DataSource createDataSource(DataBaseConfig config) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());
        return dataSource;
    }
}
