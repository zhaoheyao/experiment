package com.example.demo.test;

import com.example.demo.reposity.UserReponsitory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
test测试类必须建立在当前DeamApplicationTests类同级目录下，否则出错
测试类 需要加上2个注解：@RunWith(SpringRunner.class)和@SpringBootTest(classes = Application.class)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class javaTest {
    @Autowired
    private UserReponsitory userReponsitory;
    @Test
    public void addUserAddress(){
        userReponsitory.addUserAddress();
    }
}
