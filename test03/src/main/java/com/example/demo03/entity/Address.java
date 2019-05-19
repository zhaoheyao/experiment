package com.example.demo03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//对应数据库表中的id属性

    private String detail;//对应数据库表中的detail属性

    @ManyToOne
    private User user;

    //字段定义，相当于数据库中的字段约束
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable = false,updatable = false)
    private LocalDateTime insertTime;

    public Address(String detail){
        this.detail=detail;
    }


}
