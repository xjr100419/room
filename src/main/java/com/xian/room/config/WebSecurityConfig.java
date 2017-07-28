package com.xian.room.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xian.room.auth.UserContext;
import com.xian.room.domain.User;

/**
 *“SecurityInterceptor”类继承“HandlerInterceptorAdapter”，并重新“preHandle”方法，当为空时，则跳转到登录页面

“WebSecurityConfig”类继承“WebMvcConfigurerAdapter”，重新“addInterceptors”方法，其目的是设置拦截规则，excludePathPatterns为需要排除的规则，addPathPatterns为需要拦截的规则。
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {


    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login*");
        
        addInterceptor.excludePathPatterns("*.js");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            User user = UserContext.getCurrentUser();
            if (user != null)
                return true;

            // 跳转登录
            String url = "/logins";
            response.sendRedirect(url);
            return false;
        }
    }
}
