package com.yc.c83s3psmspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.c83s3psmspringboot.dao")
public class C83S3PsmSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(C83S3PsmSpringbootApplication.class, args);
	}

}
