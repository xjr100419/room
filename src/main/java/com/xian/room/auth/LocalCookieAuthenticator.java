package com.xian.room.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xian.room.dao.UserRepository;
import com.xian.room.domain.User;
import com.xian.room.util.CookieUtil;
import com.xian.room.util.Global;
import com.xian.room.util.Md5Util;
@Component
public class LocalCookieAuthenticator implements Authenticator{
	@Autowired
    private UserRepository userRepository;
    
	@Override
	public User authenticate(HttpServletRequest request, HttpServletResponse response) {
		String cookie = getCookieFromRequest(request, Global.Auth.UserCookieName);
        if (cookie == null) {
            return null;
        }
        return getUserByCookie(cookie);
	}
	
	
	public String getCookieFromRequest(HttpServletRequest request,String cookiename){
		return CookieUtil.getUid(request, cookiename);
	}
	
	public User getUserByCookie(String cookie){
		//"admin:b1946ac92492d2347c6235b4d2611184" user.id : md5（user.name）
		User user = null;
		if(cookie.indexOf(":")>-1){
			cookie.split(":");
			User temp =userRepository.findOne(Long.parseLong(cookie.split(":")[0]));
			if(temp!=null&&cookie.split(":")[1].equals(Md5Util.md5(temp.getName()))){
				user = temp;
			}
		}
		return user;
	}

}
