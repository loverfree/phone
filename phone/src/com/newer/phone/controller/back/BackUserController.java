package com.newer.phone.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.User;
import com.newer.phone.service.back.UserServiceBack;

@Controller
@RequestMapping("bUser")
public class BackUserController {

	@Autowired
	private UserServiceBack userService;
	
	/**
	 * 后台查看所有用户的信息
	 * @param model
	 * @return  OK
	 * @author samluby
	 */
	@RequestMapping("list")
	public String findUserAll(Model model,Integer pageNo,Integer pageSize){
		PageInfo<User> page = userService.findUserAll(pageNo,pageSize);
		model.addAttribute("page",page);
		return "MgrIndex";
	}
	
	/**
	 * 后台根据用户id获得用户信息跳转到修改用户信息的页面
	 * @param u_id
	 * @param model
	 * @return
	 * @author samluby
	 */
	@RequestMapping("update/{u_id}")
	public String update(@PathVariable("u_id")Integer u_id,Model model){
		User user = userService.getUserById(u_id);
		model.addAttribute("user",user);
		return "backUser";
	}
	
	/**
	 * 根据需修改页面传过来的信息封装成user对象对数据库进行修改信息   只能修改密码，昵称，和卡号
	 * @param user
	 * @return
	 * @author samluby
	 */
	@RequestMapping(value="updateUser",method=RequestMethod.POST)
	public String updateUser(User user){
		int isTrue = userService.updateUser(user);
		System.out.println(isTrue);
		return "redirect:list";
	}
}
