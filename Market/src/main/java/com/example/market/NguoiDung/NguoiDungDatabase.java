package com.example.market.NguoiDung;

import com.example.market.Connection;
import com.microsoft.sqlserver.jdbc.SQLServerException;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NguoiDungDatabase extends Connection {
    java.sql.Connection conn = ds.getConnection();
    Statement statement = conn.createStatement();
    ResultSet rs;


    public NguoiDungDatabase() throws SQLException {
        super();
    }

    public String Login(String username, String password) {
        String sql = String.format("Select maND from nguoiDung Where tenDN = '%s' AND matkhau = '%s'", username, password);
        try {
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
            return "false";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String Register(NguoiDung nguoiDung) {
        if(checkTenDN(nguoiDung.getTenDN())){
            if(checkSDT(nguoiDung.getSoDT())){
                String sql = String.format("INSERT INTO NguoiDung Values('%s','%s','%s','%s','%s','%s')"
                        , nguoiDung.getMaND(), nguoiDung.getTenTK(), nguoiDung.getTenDN(), nguoiDung.getMatkhau()
                        , nguoiDung.getSoDT(), nguoiDung.getDiaChi());
                try {
                    int row = statement.executeUpdate(sql);
                    return String.valueOf(row);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                return "falseSDT";
            }
        }
        else{
            return "falseND";
        }
    }

    private Boolean checkTenDN(String tenDN){
        String sql = String.format("Select maND from NguoiDung Where tenDN = '%s'",tenDN);
        try{
            rs = statement.executeQuery(sql);
            if(rs.next()){
                return false;
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Boolean checkSDT(String soDT){
        String sql = String.format("Select maND from NguoiDung Where soDT = '%s'",soDT);
        try{
            rs = statement.executeQuery(sql);
            if(rs.next()){
                return false;
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}