package com.yc.c83s3psmblog.dao;

import org.apache.ibatis.annotations.Select;

import com.yc.c83s3psmblog.bean.Category;

public interface CategoryMapper {
	
	@Select("select * from Category where id=#{id}")
	public Category selectById(int id);
	
}
