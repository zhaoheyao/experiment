package com.example.demo.reposity;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserReponsitory {
    //声明上下文环境
    @PersistenceContext
    private EntityManager em;//获取事务的上下文（持久化）环境

    public void addUserAddress(){
        User user=new User("张三");
        em.persist(user);//persist方法是将实体对象持久化（存储）到数据库
        Address address=new Address("北京");
        em.persist(address);

        Address address1=new Address("上海");
        address1.setUser(user);
        em.persist(address1);
    }
}
