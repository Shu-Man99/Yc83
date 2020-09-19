package com.yc.c83s3psmblog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.c83s3psmblog.bean.User;

public interface UserMapper {
	
	@Insert("insert into user values (null,"
			+ "#{name},#{account},#{pwd},#{phone},#{email},"
			+ "#{head},now(),#{status},#{type})")
	public int insert(User user);
	
	@Select("select * from user where account=#{account} and pwd=#{pwd}")
	public User selectBuLogin(User user);
	
	@Select("select count(*) from user where account=#{account}")
	public int countByAccount(String account);
}
