package com.newer.phone.controller.front;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import com.newer.phone.pojo.Address;
import com.newer.phone.pojo.Inform;
import com.newer.phone.pojo.User;
import com.newer.phone.service.front.UserService;

@Controller
@SessionAttributes(value={"curuser","originPwd"})
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/mgr")
	public String enterMge() {
		return "MgrIndex";
	}
	
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
		User user = userService.loginUser(uname,password);
		if (user != null) {   
			System.out.println("登录成功");
			List<Inform> informs = userService.getInform(user.getU_id());
			int count = informs.size();
			user.setCount(count);
			user.setInfrorms(informs);
			model.addAttribute("curuser", user );
			System.out.println("用户id:"+user.getU_id());
			System.out.println("用户昵称:"+user.getU_nickname());
			System.out.println("图片路径："+user.getU_pic());
			System.out.println("银行卡:"+user.getU_card());
			return "redirect:../product/brand/list";
		}
		else {
			System.out.println("信息可能有误哦！");
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
		while (password == "") {
			System.out.println("密码不能为空");
			return "redirect:userUpdate";
		}
		newInfo.setU_id(uid);
		newInfo.setU_nickname(nickname);
		newInfo.setU_pwd(password);
		System.out.println("传递过来的昵称:"+nickname);
		System.out.println("传递过来的密码:"+password);
		int count = userService.updateUser(newInfo);
		if(count == 1) {
		System.out.println("修改成功");
		return "login";
		}
		return "redirect:userUpdate";
	}
	
	@RequestMapping(value="/userUpdate")
	public String enterUserUpdate(Model m,@SessionAttribute("curuser")User user) {
		User nowUser = userService.getUserInfo(user.getU_id());
		m.addAttribute("pic", nowUser.getU_pic());
		m.addAttribute("nowName", nowUser.getU_name());
		m.addAttribute("nowNick", nowUser.getU_nickname());
		return "userUpdate";
	}
	
	@RequestMapping("/addrUpdate")
	public String getUserAddr(Model m,@SessionAttribute("curuser")User user) {
		List<Address> aList = userService.getUserAddr(user.getU_id());
		m.addAttribute("alist", aList);
		return "addrUpdate";
	}
	
	@RequestMapping(value="delAddr",method = RequestMethod.POST)
	public @ResponseBody List<String>  delAddr(Integer a_id) {
		System.out.println("删除成功");
		userService.delAddr(a_id);
		List<String> del = new ArrayList<>();
		del.add("删除成功！");
		return del;
	}
	
	@RequestMapping("/card")
	public String cardMenu(Model m,@SessionAttribute("curuser")User user) {
		User userCard = userService.getCard(user.getU_id());
		String noCard = "请添加一张卡";
		m.addAttribute("userCard", userCard);
		m.addAttribute("noCard", noCard);
		return "card";
	}
	
	@RequestMapping(value="/addCard",method = RequestMethod.POST)
	public String addCard(String ucard,Integer uid,Model m) {
		System.out.println("分割前卡号："+ucard);
		String[] arrays = ucard.split("\\s+");
		StringBuffer sb = new StringBuffer();
		for(String card : arrays) {
			System.out.println("分割后卡号（未合并）："+card);
			sb.append(card);
			String afterCard = sb.toString();
			System.out.println("分割后卡号（已合并）："+afterCard);
			userService.addCard(afterCard, uid);
		}
		return "redirect:card";
	}
	
	@RequestMapping(value="/addAddr",method = RequestMethod.POST) 
	public String addAddr(@ModelAttribute("curuser")User user,SessionStatus ss,Address addr) {
		addr.setUser(user);
		userService.addAddr(addr);
		return "redirect:addrUpdate";
	}
	
	@RequestMapping(value="/upPic",method = RequestMethod.POST)
	public String upPic(@RequestParam("url")MultipartFile file,Integer uid,Model m,HttpServletRequest request) {
		String fileName = UUID.randomUUID()+file.getOriginalFilename();
		System.out.println(file.getOriginalFilename());
		String pString = request.getSession().getServletContext().getRealPath("image");
		File dest = new File(pString,fileName);
		System.out.println(pString);
		System.out.println(file.getContentType());
		try {
			file.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		User user = new User();
		String path = "resources/image/";
		String u_pic = path + fileName;
		user.setU_pic(u_pic);
		user.setU_id(uid);
		userService.addPic(u_pic, uid);
		System.out.println("上传成功！");
		String msg = "上传成功！";
		m.addAttribute("msg", msg);
		return "redirect:userUpdate";
	}
	
}
