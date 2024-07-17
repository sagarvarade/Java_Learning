package com.dbconchecker.Beans;

public class DataBaseConfig {
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public String getUrl() {
        return url;
    }

    public DataBaseConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DataBaseConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataBaseConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public DataBaseConfig setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }
}
