package com.yc.c83s3psmspringboot.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.c83s3psmspringboot.dao.ProductMapper;
import com.yc.damai.bean.DmProduct;

@Controller
public class IndexAction {
	
	@Resource
	ProductMapper pm;
	@GetMapping("index.do")
	public String index(Model m) {
		//查询热销商品
		List<DmProduct> hlist=pm.selectByHot();
		//推送给页面
		m.addAttribute("hlist", hlist);
		
		return "index";
	}
	
	@GetMapping("detail.do")
	public String detail(Model m, int id) {
		//查询指定id商品
		DmProduct dp=pm.selectById(id);
		//推送给页面
		m.addAttribute("dp", dp);
		
		return "detail";
	}
}
