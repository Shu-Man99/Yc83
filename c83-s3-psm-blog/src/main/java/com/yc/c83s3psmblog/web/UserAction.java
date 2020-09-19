//package com.yc.c83s3psmblog.web;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//import com.yc.c83s3psmblog.bean.Result;
//import com.yc.c83s3psmblog.bean.User;
//import com.yc.c83s3psmblog.biz.BizException;
//import com.yc.c83s3psmblog.biz.UserBiz;
//
//@Controller  //默认控制器方法是执行页面跳转
//public class UserAction {
//	
//	@Resource
//	private UserBiz ubiz;
//	/**
//	 * 注册：表单提交 ===》页面跳转
//	 * @param user
//	 */
//	public String register(User user,Model m) {
//		try {
//			ubiz.register(user);
//		} catch (BizException e) {
//			e.printStackTrace();
//			m.addAttribute("msg",e.getMessage());
//			return "reg";
//		}
//		
//		return "index";
//	}
//	/**
//	 * 登录：Ajax提交 ==》Vue
//	 * @param user
//	 */
//	public Result login(User user,HttpSession session) {
//		try {
//			User dbuser = ubiz.login(user);
//			session.setAttribute("loginedUser", dbuser);
//		} catch (BizException e) {
//			e.printStackTrace();
//			return new Result(e.getMessage());
//		}
//		return new Result(1,"登陆成功");
//	}
//}
