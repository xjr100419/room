package com.xian.room.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xian.room.auth.Authenticator;
import com.xian.room.auth.BasicAuthenticator;
import com.xian.room.auth.LocalCookieAuthenticator;
import com.xian.room.auth.UserContext;
import com.xian.room.domain.User;

@Configuration
public class FilterConfiguration {
	
	@Autowired
	private BasicAuthenticator basicAuthenticator;
	@Autowired
	private LocalCookieAuthenticator localCookieAuthenticator;
	
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
    
    @Bean
    public FilterRegistrationBean initFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthFilter());
        registration.addUrlPatterns("/*");
        //添加不需要忽略的格式信息. 规则没用？？？
        //registration.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
        
        //registration.addInitParameter("paramName", "paramValue");
        registration.setName("authFilter");
        registration.setOrder(1);
        return registration;
    }
    
    public class AuthFilter implements Filter {
    	Authenticator[] authenticators = initAuthenticators();
    	
        @Override
        public void destroy() {
            // TODO Auto-generated method stub
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
        	
            // TODO Auto-generated method stub
            HttpServletRequest request = (HttpServletRequest) srequest;
            HttpServletResponse response = (HttpServletResponse) sresponse;
            System.out.println("this is MyFilter,url :"+request.getRequestURI());
            
         // 链式认证获得User:
            User user = tryGetAuthenticatedUser(request, response);
            
            try (UserContext ctx = new UserContext(user)) {
            	filterChain.doFilter(srequest, sresponse);
            }
            
            
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
            // TODO Auto-generated method stub
        }
        
        public Authenticator[] initAuthenticators(){
        	Authenticator[] a = new Authenticator[]{localCookieAuthenticator,basicAuthenticator};
        	return a;
        }
        
        public User tryGetAuthenticatedUser(HttpServletRequest srequest, HttpServletResponse sresponse){
        	User user = null;
        	for (Authenticator auth : this.authenticators) {
        		user = auth.authenticate(srequest, sresponse);
                if (user != null) {
                    break;
                }
        	}
        	return user;
        }
    }
}
