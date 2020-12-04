package com.example.springdata.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    //@Query(nativeQuery = true, value = "select * from account where usrname='{0}'")
    //JPAQuery 도 사용 가능
    Optional<Account> findByUsername(String username);
}
