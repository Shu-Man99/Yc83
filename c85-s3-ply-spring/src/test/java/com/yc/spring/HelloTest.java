package com.yc.spring;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.UserDao;



public class HelloTest {
	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
	}
	@After
	public void after() {
		ctx.close();
	}
	@Test
	public void test() {
		//创建spring容器对象
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("beans.xml");
		Hello h = (Hello)ctx.getBean("hello");
		h.sayHello();
		ctx.close();
	}
	
	@Test
	public void test1() {
		//创建spring容器对象
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("beans.xml");
		UserDao udao1 = (UserDao) ctx.getBean("mdao");
		UserDao udao2 = (UserDao) ctx.getBean("odao");
		udao1.SelectUserId("sdfjh");
		udao2.SelectUserId("sdfjh");
	}
	@Test
	public void test2() {
		Person p1 = (Person) ctx.getBean("p1");
		Assert.assertEquals("武松", p1.getName());
		Assert.assertEquals(35, p1.getAge());
		Assert.assertEquals(4, p1.getKilleds().size());
	}
	@Test
	public void test3() {
		Person p1 =  ctx.getBean(Person.class);
		Assert.assertEquals("李逵", p1.getName());
		Assert.assertEquals(33, p1.getAge());
		Assert.assertEquals(null, p1.getKilleds());
	}
}
