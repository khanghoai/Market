package com.example.market.NguoiDung;

import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class NguoiDungServies {

    NguoiDungDatabase nguoiDungDatabase = new NguoiDungDatabase();

    public NguoiDungServies() throws SQLException {
    }

    public String Login(String username, String password){
        return nguoiDungDatabase.Login(username,password);
    }

    public String Register(NguoiDung nguoiDung){
        return nguoiDungDatabase.Register(nguoiDung);
    }
}
