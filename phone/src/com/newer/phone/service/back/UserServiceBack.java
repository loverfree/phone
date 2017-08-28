package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.User;

/**
 * 后台用户管理service层
 * @author Kiven
 *
 */
public interface UserServiceBack {
	//查看所有用户
	List<User> findUserAll();
	//编辑用户信息
	int updateUser(User user);
	//根据id查找用户
	User getUserById(Integer u_id);
	
}
