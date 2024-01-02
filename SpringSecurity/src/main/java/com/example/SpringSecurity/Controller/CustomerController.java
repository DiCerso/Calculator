package com.example.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CustomerController {

    @GetMapping("/index")
    public String index(){
        return "HelloWorld";
    }

    @GetMapping("/index2")
    public String index2(){
        return "HelloWorld not SECURED";
    }
}
