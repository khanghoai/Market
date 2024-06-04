package com.example.market;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;

public class Connection {

    protected SQLServerDataSource ds;

    protected Connection(){
        ds = new SQLServerDataSource();
        ds.setServerName("DESKTOP-0V6GLHH\\SQLEXPRESS");
        ds.setDatabaseName("market");
        ds.setPortNumber(1433);
        ds.setUser("sa");
        ds.setPassword("iceWater#2");
        ds.setEncrypt("true");
        ds.setTrustServerCertificate(true);

        try(java.sql.Connection conn = ds.getConnection()){
            System.out.println("Connection to database");
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
