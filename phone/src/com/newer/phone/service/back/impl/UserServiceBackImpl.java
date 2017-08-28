package com.newer.phone.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.UserMapper;
import com.newer.phone.pojo.User;
import com.newer.phone.service.back.UserServiceBack;

//UserService实现类
@Service
public class UserServiceBackImpl implements UserServiceBack{
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 后台查看所有用户
	 */
	@Override
	public List<User> findUserAll() {
		return userMapper.findUserAll();
	}

	/**
	 * 后台修改用户信息
	 */
	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public User getUserById(Integer u_id) {
		return userMapper.getUserById(u_id);
	}

}
