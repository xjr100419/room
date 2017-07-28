package com.xian.room.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xian.room.domain.User;

public class CookieUtil {
	/**
     * 添加cookie
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        
        //cookie.setDomain(".189.cn"); // cookie作用域
        response.addCookie(cookie);
    }

    /**
     * 删除cookie
     * 
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletResponse response, String name) {
        Cookie uid = new Cookie(name, null);
        uid.setPath("/");
        uid.setMaxAge(0);
        response.addCookie(uid);
    }

    /**
     * 获取cookie值
     * 
     * @param request
     * @return
     */
    public static String getUid(HttpServletRequest request,String cookieName) {
        Cookie cookies[] = request.getCookies();
        if(cookies==null)return null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
    
    /**
     * 检索所有cookie 封装到map集合 以其cookie name作为key cookie value作为value
     * 
     * @param request
     * @return
     */
    public static Map<String, String> ReadCookieMap(HttpServletRequest request) {
        Map<String, String> cookieMap = new HashMap<String, String>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }
    
    public static void buileCookie(HttpServletResponse response,User user){
    	StringBuffer sbf = new StringBuffer("");
    	//"admin:b1946ac92492d2347c6235b4d2611184" user.id : md5（user.name）
    	sbf.append(user.getId()).append(":").append(Md5Util.md5(user.getName()));
    	addCookie(response, Global.Auth.UserCookieName, sbf.toString(), Global.Auth.UserCookiemaxAge);;
    }
    
}
