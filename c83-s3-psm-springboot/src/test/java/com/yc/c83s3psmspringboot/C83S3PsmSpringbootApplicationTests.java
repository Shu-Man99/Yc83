package com.yc.c83s3psmspringboot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.c83s3psmspringboot.dao.ProductMapper;

@SpringBootTest
class C83S3PsmSpringbootApplicationTests {

	@Resource
	ProductMapper pm;
	@Test
	void contextLoads() {
		Assert.isTrue(pm.selectAll().size() > 0, "没有数据");
	}

}
