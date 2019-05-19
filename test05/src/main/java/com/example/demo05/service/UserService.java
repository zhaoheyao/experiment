package com.example.demo05.service;

import com.example.demo05.aspect.MyIntercetor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    public String welcome(String name){
        return name+" 你好，欢迎来买车！";
    }
    //注意这里有注解：MyIntercetor
    @MyIntercetor(value=MyIntercetor.AuthorityType.ADMIN)
    public void addUser(){
        log.debug("ADMIN authority");
    }
    public void getUser(){
        log.debug("commom user autority");
    }
    public void buyCar(){
        log.debug("{}",this.getClass().toString());
    }
}
