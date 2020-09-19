package com.yc.c83s3psmblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.c83s3psmblog.bean.User;
import com.yc.c83s3psmblog.dao.UserMapper;

@Service
public class UserBiz {
	@Resource
	private UserMapper uMapper;
	
	public void register(User user) throws BizException{
		
		if(uMapper.countByAccount(user.getAccount()) > 0) {
			throw new BizException("该用户已经存在");
		}
		uMapper.insert(user);
	}
	
	public User login(User user) throws BizException{
		User dbuser = uMapper.selectBuLogin(user);
		if(dbuser == null) {
			throw new BizException("用户名或密码错误");
		}
		return dbuser;
	}
}
