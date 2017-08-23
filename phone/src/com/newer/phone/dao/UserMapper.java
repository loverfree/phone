package com.newer.phone.dao;


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
}
