package com.yc.c83s3psmblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.c83s3psmblog.bean.Comment;
import com.yc.c83s3psmblog.dao.CommentMapper;

@Service
public class CommentBiz {
	@Resource
	private CommentMapper cMapper;
	
	public Comment create(Comment comm) {
		cMapper.insert(comm);
		return comm;
	}
}
