package com.example.market.SanPham;

import com.example.market.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDatabase extends Connection {
    java.sql.Connection cnn = ds.getConnection();
    Statement statement = cnn.createStatement();
    ResultSet rs;

    public SanPhamDatabase() throws SQLException {
        super();
    }

    public List<SanPham> getAllSP(){
        List<SanPham> sps = new ArrayList<SanPham>();
        String sql = "Select maSP,tenSP,giaSP from SanPham";
        try{
            rs = statement.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("maSP"));
                sp.setTenSP(rs.getString("tenSP"));
                sp.setGiaSP(rs.getString("giaSP"));
                sps.add(sp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sps;
    }

    public String themSP(SanPham sanPham){
        String sql = String.format("INSERT INTO sanPham Values('%s','%s','%s','%s','%s','%s')",
                sanPham.getMaSP(),sanPham.getTenSP(),sanPham.getMaShop(),sanPham.getGiaSP(),
                sanPham.getLoaiSP(),sanPham.getSoLuongSP());
        try{
            int row = statement.executeUpdate(sql);
            return String.valueOf(row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
