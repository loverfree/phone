package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.User;

/**
 * 后台用户管理service层
 * @author Kiven
 *
 */
public interface UserService {
	//查看所有用户
	List<User> findAllUser();
	//编辑用户信息
	int updateCartByProduct(Integer u_id);
	
}
