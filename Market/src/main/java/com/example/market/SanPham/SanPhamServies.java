package com.example.market.SanPham;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SanPhamServies {
    private final SanPhamDatabase sanPhamDatabase = new SanPhamDatabase();

    public SanPhamServies() throws SQLException {
    }

    public List<SanPham> getAllSanPham(){
        return sanPhamDatabase.getAllSP();
    }

    public String themSP(SanPham sanPham){
        return sanPhamDatabase.themSP(sanPham);
    }
}
