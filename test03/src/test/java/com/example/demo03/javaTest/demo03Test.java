package com.example.demo03.javaTest;

import com.example.demo03.entity.Address;
import com.example.demo03.entity.User;
import com.example.demo03.reposity.UserReponsitory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class demo03Test {
    @Autowired
    UserReponsitory userReponsitory;
    @Test
    public void test(){
        User user=new User("小明");
        Address address=new Address("广东");
        address.setUser(user);
        userReponsitory.addAddress(address,3);
        userReponsitory.addUser(user);
    }
}
