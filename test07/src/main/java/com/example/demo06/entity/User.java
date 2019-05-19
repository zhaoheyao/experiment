package com.example.demo06.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class User {
    @Size(min = 4,max = 6,message = "输入的用户名为${validateValue},长度必须" +
            "大于{min}小于{max}")
    private String userName;

    private String password;

    @Max(value = 60,message = "你的年龄必须小于{value}")
    @Min(value=18,message = "你的年龄必须大于{value}")
    private int age;
    @Email
    private String email;
}
