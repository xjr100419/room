package com.xian.room.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.xian.room.dao.base.BaseRepository;
import com.xian.room.domain.User;

public interface  UserRepository extends BaseRepository<User, Long>{
	List<User> findByName(String name);
	User findByNameOrEmail(String name, String email);
	
}
