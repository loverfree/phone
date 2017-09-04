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
	 * ��̨�鿴�����û�����Ϣ
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
	 * ��̨�����û�id����û���Ϣ��ת���޸��û���Ϣ��ҳ��
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
	 * �������޸�ҳ�洫��������Ϣ��װ��user��������ݿ�����޸���Ϣ   ֻ���޸����룬�ǳƣ��Ϳ���
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
