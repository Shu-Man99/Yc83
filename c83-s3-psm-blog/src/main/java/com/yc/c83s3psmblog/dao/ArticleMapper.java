package com.yc.c83s3psmblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.c83s3psmblog.bean.Article;

public interface ArticleMapper {
	@Select("select * from article order by createtime desc")
	@Results(id="rmAm",value= {
		@Result(id = true,column = "id",property = "id"),
		@Result(column = "categoryid",property = "categoryid"),
		@Result(
				column = "categoryid",
				property = "category",
				one=@One(select="com.yc.c83s3psmblog.dao.CategoryMapper.selectById"))
		})
	public List<Article> selectByNew();
	
	@Select("select * from article where id = #{id}")
	@ResultMap("rmAm")
	public Article selectById(int id);
	
	@Insert("insert into article values(#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs},"
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public int insert(Article a);
}
