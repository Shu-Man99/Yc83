package com.yc.c83s3psmblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.c83s3psmblog.bean.Article;
import com.yc.c83s3psmblog.dao.ArticleMapper;

@Service
public class ArticleBiz {
	
	@Resource
	private ArticleMapper aMapper;
	
	public int create(Article art) {
		return aMapper.insert(art);
	}
}
