package com.yc.crbook;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.crbook.bean.User;
import com.yc.crbook.bean.UserExample;
import com.yc.crbook.dao.UserMapper;

@SpringBootTest
class ApplicationTests {

	@Resource
	UserMapper uMapper;
	
	@Test
	void contextLoads() {
		UserExample ue = new UserExample();
		ue.createCriteria().andAccountEqualTo("admin")
		.andPwdEqualTo("111");
		
		List<User> list = uMapper.selectByExample(ue);
		Assert.assertEquals(1,list.size());
	}

}
