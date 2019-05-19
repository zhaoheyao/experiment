package com.example.demo04.demo04Test;

import com.example.demo04.entity.Address;
import com.example.demo04.entity.User;
import com.example.demo04.entity.UserAddress;
import com.example.demo04.repository.AddressRepositoty;
import com.example.demo04.repository.UserAddressRepository;
import com.example.demo04.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class javaTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepositoty addressRepositoty;
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Test
    public void init(){
        User user=new User("小红");
        userRepository.save(user);
        User user1=new User("小绿");
        userRepository.save(user1);

        Address address=new Address("西安");
        addressRepositoty.save(address);
        Address address1=new Address("青岛");
        addressRepositoty.save(address1);

        UserAddress userAddress=new UserAddress(user,address);
        userAddressRepository.save(userAddress);

        UserAddress userAddress1=new UserAddress(user1,address1);
        userAddressRepository.save(userAddress1);

    }
}
