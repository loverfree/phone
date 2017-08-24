package com.newer.phone.controller.front;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.newer.phone.pojo.User;
import com.newer.phone.service.front.UserService;

@Controller
@SessionAttributes("curuname")
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/main")
	public String enterReg() {
		return "reg";
	}
	
	@RequestMapping("/login")
	public String enterLogin() {
		return "login";
	}
	
	@RequestMapping("/chkUser")
	public @ResponseBody List<String> chkUser(Model model, String name) {

		List<String> userList = new ArrayList<>();
		User userExist = userService.chkUser(name);

		if (userExist != null) {
			userList.add("被注册了~");
			System.out.println("被注册了~");
		} else {
			userList.add("用户名可用~");
			System.out.println("用户名可用~");
		}
		return userList;
	}
	
	@RequestMapping(value="/regUser",method=RequestMethod.POST)
	public String regUser(Model model,String uname,String password) {
		model.addAttribute("uname", uname );
		model.addAttribute("password", password);
		userService.regUser(uname, password);
		return "redirect:login";
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST) 
	public String loginUser(Model model,String uname,String password) {
		model.addAttribute("uname", uname );
		model.addAttribute("password", password);
		User user = userService.loginUser(uname, password);
		if (user != null) {   
			System.out.println("登录成功");
			model.addAttribute("curuname", uname );
			return "redirect:../product/brand";
		}
		else {
			System.out.println("信息可能有误哦！");
		}
		return "redirect:login";
	}
	
	@RequestMapping(value="logout",method = RequestMethod.GET)
	public String logOut(@ModelAttribute("curuname")String uname,SessionStatus ss) {
		ss.setComplete();
		return "redirect:login";
	}
	
}
