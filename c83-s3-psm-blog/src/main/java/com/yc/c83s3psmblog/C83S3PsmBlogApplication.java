package com.yc.c83s3psmblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.c83s3psmblog.web.LoginInterceptor;

@SpringBootApplication
@MapperScan("com.yc.c83s3psmblog.dao")
public class C83S3PsmBlogApplication implements WebMvcConfigurer{
	
	public static void main(String[] args) {
		SpringApplication.run(C83S3PsmBlogApplication.class, args);
	}
	
	/**
	 *  拦截器注册方法
	 *  参数：拦截器注册器
	 */
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
		ir.addPathPatterns("/toAddArticle","/addArticle.do","/comment");
	}

}
