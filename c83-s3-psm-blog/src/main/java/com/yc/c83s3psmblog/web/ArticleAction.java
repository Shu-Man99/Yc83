package com.yc.c83s3psmblog.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yc.c83s3psmblog.bean.Article;
import com.yc.c83s3psmblog.bean.User;
import com.yc.c83s3psmblog.biz.ArticleBiz;
import com.yc.c83s3psmblog.dao.ArticleMapper;
import com.yc.c83s3psmblog.util.Utils;

@RestController
public class ArticleAction {
	
	@Resource
	private ArticleBiz abiz;
	
	@Resource
	private ArticleMapper amapper;
	
	@GetMapping("article")
	public ModelAndView article(int id,ModelAndView mav) {
		mav.addObject("article", amapper.selectById(id));
		mav.setViewName("article");
		return mav;
	}
	
	@GetMapping("toAddArticle")
	public ModelAndView toAddArticle(ModelAndView mav) {
		mav.setViewName("addArticle");
		return mav;
	}
	
	@PostMapping("addArticle.do")
	public ModelAndView addArticle(@Valid Article a,Errors errors,ModelAndView mav,
			@SessionAttribute("loginedUser") User user) {
		if(errors.hasErrors()) {
			mav.addObject("errors",Utils.asMap(errors));
			mav.addObject("article",a);
			mav.setViewName("addArticle");
		}else {
			a.setAuthor(user.getName());
			abiz.create(a);
			mav.setViewName("redirect:article?id=" + a.getId());
		}
		return mav;
	}
}
