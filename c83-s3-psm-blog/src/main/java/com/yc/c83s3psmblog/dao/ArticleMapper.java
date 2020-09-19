package com.yc.c83s3psmblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.c83s3psmblog.bean.Article;

public interface ArticleMapper {
	@Select("select * from article order by createtime desc")
	public List<Article> selectByNew();
	
	@Select("select * from article where id = #{id}")
	public Article selectById(int id);
}
