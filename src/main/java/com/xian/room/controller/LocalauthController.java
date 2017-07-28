package com.xian.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xian.room.dao.LocalauthRepository;


@RestController
@RequestMapping("/localauth")
public class LocalauthController {
	@Autowired
    private LocalauthRepository localauthRepository ;
	
    
}
