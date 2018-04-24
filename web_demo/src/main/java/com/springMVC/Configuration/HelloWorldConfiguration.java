package com.springMVC.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 此为配置类，可以被看作是替代 spring-servlet.xml，提供了组件的扫描和视图解析器的信息
 * @author dj
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springMVC")	// 提示spring 在哪个包中寻找管理 beans/classes.
public class HelloWorldConfiguration {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}		
}
