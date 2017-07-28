package com.xian.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.xian.room.dao.base.BaseRepositoryFactoryBean;

@EnableJpaRepositories(basePackages = {"com.xian.room"},
repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class//指定自己的工厂类
)
@SpringBootApplication
public class RoomApplication {

	public static void main(String[] args) {
		//关闭自动重启
		//设置 spring.devtools.restart.enabled 属性为false，可以关闭该特性。可以在application.properties中设置，也可以通过设置环境变量的方式。
		//System.setProperty("spring.devtools.restart.enabled","false");
		
		SpringApplication.run(RoomApplication.class, args);
	}
}
