package com.xian.room.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xian.room.domain.Localauth;
import com.xian.room.domain.User;

public interface  LocalauthRepository extends JpaRepository<Localauth, Long>{
	
	//@Query("select l from Localauth l where l.username=?1")
	@Query(value = " SELECT * FROM Localauth l left join user u on l.user_id = u.id  WHERE l.username = ?1 ", nativeQuery = true)
	public List<Localauth> selectbyname(String name);
	
	Localauth findByUsernameAndPassword(String username, String password);
	
}
