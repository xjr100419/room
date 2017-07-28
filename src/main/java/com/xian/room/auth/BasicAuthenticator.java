package com.xian.room.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.xian.room.dao.LocalauthRepository;
import com.xian.room.dao.UserRepository;
import com.xian.room.domain.Localauth;
import com.xian.room.domain.User;
import com.xian.room.util.CookieUtil;
@Component
public class BasicAuthenticator implements Authenticator {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private LocalauthRepository localauthRepository ;
	
    public User authenticate(HttpServletRequest request, HttpServletResponse response) {
    	User user = null;
        String auth = getHeaderFromRequest(request, "Authorization");
        if (auth == null) {
            return null;
        }
        String username = parseUsernameFromAuthorizationHeader(auth);
        String password = parsePasswordFromAuthorizationHeader(auth);
        user = authenticateUserByPassword(username, password);
        if(user!=null){
        	CookieUtil.buileCookie(response, user);
        }
        return user;
    }
    
    
    public String getHeaderFromRequest(HttpServletRequest request,String cookiename){
    	//Enumeration<String> names = request.getHeaderNames();
		return request.getHeader(cookiename);
	}
    
    public String parseUsernameFromAuthorizationHeader(String auth){
    	
		return auth.split(",")[0];
	}
    
    public String parsePasswordFromAuthorizationHeader(String auth){
		return auth.split(",")[1];
	}
    
    public User authenticateUserByPassword(String username,String password){
    	User user = null;
    	Localauth localauth = localauthRepository.findByUsernameAndPassword(username, password);
    	if(localauth!=null&&!StringUtils.isEmpty(localauth.getUser_id())){
    		user = userRepository.findOne(localauth.getUser_id());
    	}
		return user;
	}

}
