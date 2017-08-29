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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.newer.phone.pojo.Address;
import com.newer.phone.pojo.User;
import com.newer.phone.service.front.UserService;

@Controller
@SessionAttributes(value={"curuser","originPwd"})
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
			userList.add("��ע����~");
			System.out.println("��ע����~");
		} else {
			userList.add("�û�������~");
			System.out.println("�û�������~");
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
	
//	@RequestMapping(value="/loginUser",method=RequestMethod.POST) 
//	public String loginUser(Model model,String uname,String password) {
//		model.addAttribute("uname", uname );
//		model.addAttribute("password", password);
//		User user = userService.loginUser(uname, password);
//		if (user != null) {   
//			System.out.println("��¼�ɹ�");
//			model.addAttribute("curuname", uname );
//			return "redirect:../product/brand/list";
//		}
//		else {
//			System.out.println("��Ϣ��������Ŷ��");
//		}
//		return "redirect:login";
//	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST) 
	public String loginUser(Model model,String uname,String password) {
		model.addAttribute("uname", uname);
		model.addAttribute("password", password);
		User user = userService.loginUser(uname,password);
		if (user != null) {   
			System.out.println("��¼�ɹ�");
			model.addAttribute("curuser", user );
			model.addAttribute("originPwd", password);
			System.out.println("�û�id:"+user.getU_id());
			System.out.println("�û��ǳ�:"+user.getU_nickname());
			System.out.println("���п�:"+user.getU_card());
			return "redirect:../product/brand/list";
		}
		else {
			System.out.println("��Ϣ��������Ŷ��");
		}
		return "redirect:login";
	}
	
	@RequestMapping(value="logout",method = RequestMethod.POST)
	public String logOut(@ModelAttribute("curuser")User user,SessionStatus ss) {
		ss.setComplete();
		return "redirect:login";
	}
	
	@RequestMapping(value="/upt",method = RequestMethod.POST)
	public String updateUser(Model m,Integer uid,String nickname,String password) {
		User newInfo = new User();
		newInfo.setU_id(uid);
		newInfo.setU_nickname(nickname);
		newInfo.setU_pwd(password);
		System.out.println("���ݹ������ǳ�:"+nickname);
		System.out.println("���ݹ���������:"+password);
		int count = userService.updateUser(newInfo);
		if(count == 1) {
		System.out.println("�޸ĳɹ�");
		return "login";
		}
		return "userUpdate";
	}
	
	@RequestMapping(value="/userUpdate")
	public String enterUserUpdate() {
		return "userUpdate";
	}
	
//	@RequestMapping(value="/addrUpdate")
//	public String enterAddrUpdate() {
//		return "addrUpdate";
//	}
	
	@RequestMapping("/addrUpdate")
	public String getUserAddr(Model m,@SessionAttribute("curuser")User user) {
		List<Address> aList = userService.getUserAddr(user.getU_id());
		m.addAttribute("alist", aList);
		return "addrUpdate";
	}
	
}
