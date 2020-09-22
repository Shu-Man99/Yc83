package com.yc.c83s3psmblog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.c83s3psmblog.dao.ArticleMapper;

@Controller
public class IndexAction {
	
	@Resource
	private ArticleMapper amapper;
	
	//@RequestParam(defaultValue = "1") int page
//	@GetMapping("/")
//	public String index(Model m,@RequestParam(defaultValue = "1") int page) {
//		PageHelper.startPage(page,5);
//		m.addAttribute("alist", amapper.selectByNew());
//		return "index";
//	}
//	
	@GetMapping("/")
	public String index(Model m,@RequestParam(defaultValue = "1") int page) {
		//在执行查询方法前，调用分页参数设置
		PageHelper.startPage(page,5);
		m.addAttribute("alist",amapper.selectByNew());
		return "index";
	}
}
