package com.example.demo04.repository;

import com.example.demo04.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface AddressRepositoty extends JpaRepository<Address, Integer> {
    @Query("select a FROM Address a WHERE a.detail=:detail")
    List<Address> list(@Param("detail") String detail);
}
