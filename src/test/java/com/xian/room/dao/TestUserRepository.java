package com.xian.room.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.xian.room.domain.TestUser;

public interface  TestUserRepository extends JpaRepository<TestUser, Long>{
	TestUser findByUserName(String userName);
	TestUser findByUserNameOrEmail(String username, String email);
}
