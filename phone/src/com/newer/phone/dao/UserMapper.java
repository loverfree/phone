package com.newer.phone.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * 用户dao层
 * @author Kiven
 *
 */

import com.newer.phone.pojo.User;
@Repository
public interface UserMapper {

	// 获取用户信息结果集,判断用户是否存在
	User chkUser(@Param("u_name")String u_name);
	
	// 用户注册
	int regUser(User user);
	
	// 用户登录
	User loginUser(@Param("u_name")String u_name,@Param("u_pwd")String u_pwd);
	
	// 用户修改自己的信息
	int updateUser(User user);
	
	//后台管理员查看所有用户对的信息
	List<User> findUserAll();
	
//	//后天管理员编辑用户的信息
//	int updateUserBack(User user);
	
	User getUserById(@Param("u_id")Integer u_id);
}
