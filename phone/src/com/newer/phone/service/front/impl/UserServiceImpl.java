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
	
}
