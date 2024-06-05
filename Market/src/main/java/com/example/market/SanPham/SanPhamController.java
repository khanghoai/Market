package com.example.market.SanPham;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping(path = "api/SanPham")
public class SanPhamController {

    private final SanPhamServies sanPhamServies;

    public SanPhamController(SanPhamServies sanPhamServies) {
        this.sanPhamServies = sanPhamServies;
    }

//    @GetMapping
//    public String Test(){
//        return "Hello World";
//    }

    @GetMapping
    public List<SanPham> getAllSP(){
        return sanPhamServies.getAllSanPham();
    }

    @PostMapping
    public String themSP(@RequestBody SanPham sanPham){
        return sanPhamServies.themSP(sanPham);
    }
}
