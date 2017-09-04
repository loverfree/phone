package com.newer.phone.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public PageInfo<User> findUserAll(Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?6:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<User> list = userMapper.findUserAll();
	    PageInfo<User> page = new PageInfo<>(list);
		return page;
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
