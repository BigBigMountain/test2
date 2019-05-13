package com.lyyh.greenhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/console")
public class CenterController {


	/*
	 * 首页index.do
	 */
	@RequestMapping("/index.do")
	public String index(){
		return "index";
	}
	@RequestMapping("/top.do")
	public String top(){
		return "top";
	}
	@RequestMapping("/main.do")
	public String main(){
		return "main";
	}
	
}
