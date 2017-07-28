package com.xian.room.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xian.room.dao.LocalauthRepository;
import com.xian.room.dao.UserRepository;
import com.xian.room.domain.Localauth;
import com.xian.room.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private LocalauthRepository localauthRepository ;
	
    @RequestMapping("/save")
    public User save() {
    	User user = new User();
    	user.setName("xian");
    	userRepository.save(user);
        return user;
    }
    
    @RequestMapping("/getUser")
    public List<Localauth> getUser() {
    	List<User> user=new ArrayList<User>();
    	//user = userRepository.findByName("xian");
    	
    	List<Object[]> list = userRepository.listBySQL(" select * from user ");
    	List<Localauth> localauths = new ArrayList<Localauth>();
    	localauths = localauthRepository.selectbyname("xianjr");
    	
    	
    	User u = userRepository.findOne(1l);
        return localauths;
    }
    
    @RequestMapping("/sign")
    public User sign() {
    	User user = new User();
    	user.setName("xian");
    	userRepository.save(user);
    	
    	Localauth localauth = new Localauth(); 
    	localauth.setUser_id(user.getId());
    	localauth.setUsername("xianjr");
    	localauth.setPassword("123456");
    	localauthRepository.save(localauth);
        return user;
    }
    
}
