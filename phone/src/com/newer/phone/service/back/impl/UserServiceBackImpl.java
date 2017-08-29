package com.newer.phone.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.UserMapper;
import com.newer.phone.pojo.User;
import com.newer.phone.service.back.UserServiceBack;

//UserServiceʵ����
@Service
public class UserServiceBackImpl implements UserServiceBack{
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * ��̨�鿴�����û�
	 */
	@Override
	public List<User> findUserAll() {
		return userMapper.findUserAll();
	}

	/**
	 * ��̨�޸��û���Ϣ
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
