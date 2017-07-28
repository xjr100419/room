package com.xian.room.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xian.room.auth.UserContext;
import com.xian.room.domain.User;
import com.xian.room.util.CookieUtil;
import com.xian.room.util.Global;

@Controller
public class MainController {

	@RequestMapping("/")
    public String index(String account, Model model) {
    	User user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/logins")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPost")
    public @ResponseBody Map<String, Object> loginPost(String username, String password) {
    	User user = UserContext.getCurrentUser();
    	
        Map<String, Object> map = new HashMap<>();
        if (user==null) {
            map.put("success", false);
            map.put("message", "密码错误11");
            return map;
        }

        // 设置session
        //session.setAttribute(WebSecurityConfig.SESSION_KEY, account);

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        // 移除session
        //session.removeAttribute(WebSecurityConfig.SESSION_KEY);
    	CookieUtil.removeCookie(response, Global.Auth.UserCookieName);
        return "login";
    }
}
