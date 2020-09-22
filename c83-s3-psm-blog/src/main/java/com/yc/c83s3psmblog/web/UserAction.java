package com.yc.c83s3psmblog.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.c83s3psmblog.bean.Result;
import com.yc.c83s3psmblog.bean.User;
import com.yc.c83s3psmblog.biz.BizException;
import com.yc.c83s3psmblog.biz.UserBiz;
import com.yc.c83s3psmblog.util.Utils;

@Controller  //默认控制器方法是执行页面跳转
public class UserAction {
	
	@Resource
	private UserBiz ubiz;
	/**
	 * 注册：表单提交 ===》页面跳转
	 * 
	 */
	@PostMapping("reg.do")
	public String register(@Valid User user,Errors errors,Model m) {
		
		if(errors.hasErrors()) {
			m.addAttribute("errors",Utils.asMap(errors));
			m.addAttribute("user",user);
			return "reg";
		}
		try {
			ubiz.register(user);
		} catch (BizException e) {
			e.printStackTrace();
			errors.rejectValue("account", "account",e.getMessage());
			m.addAttribute("errors",Utils.asMap(errors));
			m.addAttribute("user",user);
			return "reg";
		}
		//使用响应重定向方式跳转
		return "redirect:/";
	}
	@GetMapping("toreg")
	public String toreg() {
		return "reg";
	}
	/**
	 * 登录：Ajax提交 ==》Vue
	 * 
	 */
	@RequestMapping("login.do")
	@ResponseBody
	public Result login(@Valid User user,Errors errors,HttpSession session) {
		try {
			if(errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")) {
				Result res = new Result(0,"验证错误",errors.getFieldErrors());
				return res;
			}
			User dbuser = ubiz.login(user);
			session.setAttribute("loginedUser", dbuser);
			return new Result(1,"登陆成功",dbuser);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(e.getMessage());
		}
	}
	
}
