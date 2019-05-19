package com.example.demo01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello_world {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!thanks,god!";
    }
}
