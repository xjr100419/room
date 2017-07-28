package com.xian.room;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xian.room.dao.TestUserRepository;
import com.xian.room.domain.TestUser;


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class UserRepositoryTests {

/*    @Autowired
    private TestUserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
        
        userRepository.save(new TestUser("aa1", "aa123456", "aa@126.com", "aa",formattedDate));
        userRepository.save(new TestUser("bb2", "bb123456", "bb@126.com", "bb",formattedDate));
        userRepository.save(new TestUser("cc3", "cc123456", "cc@126.com", "cc",formattedDate));

        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb2", "").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }*/

}
