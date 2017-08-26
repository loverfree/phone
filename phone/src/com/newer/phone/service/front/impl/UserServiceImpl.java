package com.newer.phone.service.front.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.UserMapper;
import com.newer.phone.pojo.User;
import com.newer.phone.service.front.UserService;
import com.newer.phone.util.PwdEncrypt;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User chkUser(String u_name) {
		User userInfo = userMapper.chkUser(u_name);
		return userInfo;
	}

	@Override
	public int regUser(String u_name, String u_pwd) {
		int count = 0;
		System.out.println(u_pwd);
		PwdEncrypt pe = new PwdEncrypt();
		String sha_pwd = pe.md5Pwd(u_pwd);
		User user = new User();
		user.setU_name(u_name);
		user.setU_pwd(sha_pwd);
		userMapper.regUser(user);
		return count;
	}

	@Override
	public User loginUser(String u_name, String u_pwd) {
		PwdEncrypt pe = new PwdEncrypt();
		String sha_pwd = pe.md5Pwd(u_pwd);
		User user = userMapper.loginUser(u_name, sha_pwd);
	    return user;
	}

	@Override
	public int updateUser(User user) {
		int count = 0;
		PwdEncrypt pe = new PwdEncrypt();
		System.out.println("修改前的号码："+user.getU_name());
		System.out.println("加密前的密码："+user.getU_pwd());
		String sha_pwd = pe.md5Pwd(user.getU_pwd());
		user.setU_pwd(sha_pwd);
		System.out.println("SHA后密码："+sha_pwd);
		System.out.println("修改后昵称："+user.getU_nickname());
		userMapper.updateUser(user);
		System.out.println("进入service层");
		return count;
	}
	
}
