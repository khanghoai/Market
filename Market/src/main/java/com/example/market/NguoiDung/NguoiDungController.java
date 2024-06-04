package com.example.market.NguoiDung;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping(path = "api/nguoiDung")
public class NguoiDungController {

    private final NguoiDungServies nguoiDungServies;

    @Autowired
    public NguoiDungController(NguoiDungServies nguoiDungServies) {
        this.nguoiDungServies = nguoiDungServies;
    }

    @GetMapping
    public String test(){
        return "Test";
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public String Login(@RequestBody NguoiDung nguoiDung){
        if(nguoiDung.getSoDT() != null){
            return nguoiDungServies.Register(nguoiDung);
        }
        return nguoiDungServies.Login(nguoiDung.getTenDN(),nguoiDung.getMatkhau());
    }

    //CROS
    @RequestMapping(method = RequestMethod.OPTIONS)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity optionTest(){
        return ResponseEntity.ok(HttpStatus.OK);
    }
}