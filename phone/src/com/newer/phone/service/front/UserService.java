package com.newer.phone.service.front;

import com.newer.phone.pojo.User;

public interface UserService {

	// 获取用户信息结果集
	User chkUser(String u_name);
	
	// 用户注册
	int regUser(String u_name,String u_pwd);
	
	// 验证用户是否存在
	User loginUser(String u_name,String u_pwd);
	
	// 用户修改自己的信息
	int updateUser(User user);
	
}
