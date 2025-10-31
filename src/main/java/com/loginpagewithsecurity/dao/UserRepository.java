package com.loginpagewithsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loginpagewithsecurity.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
	@Query(nativeQuery = true,value="select * from user where username=:username")
	User findByUsername(@Param(value = "username") String username);
	
}
