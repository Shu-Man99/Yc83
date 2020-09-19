package com.yc.c83s3psmblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.c83s3psmblog.dao")
public class C83S3PsmBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(C83S3PsmBlogApplication.class, args);
	}

}
