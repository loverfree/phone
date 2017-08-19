package com.newer.phone.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/")
	public String test(){
		System.out.println("Æô¶¯Íê³É");
		return "index";
	}
}
