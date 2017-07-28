package com.xian.room.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xian.room.domain.TestUser;

//@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    
    @RequestMapping("/getUser")
    public TestUser getUser() {
    	TestUser user=new TestUser();
        user.setUserName("小明");
        user.setPassWord("xxxx");
        return user;
    }
}
