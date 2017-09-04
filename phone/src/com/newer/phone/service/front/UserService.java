package com.newer.phone.service.front;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newer.phone.pojo.Address;
import com.newer.phone.pojo.User;

public interface UserService {

	// 获取用户信息结果集
	User chkUser(String u_name);
	
	// 用户注册
	int regUser(String u_name,String u_pwd);
	
	// 验证用户是否存在然后登录
	User loginUser(String u_name,String u_pwd);
	
	// 登录后根据id获得用户信息
	User getUserInfo(Integer u_id);
	
	// 用户修改自己的信息
	int updateUser(User user);
	
	// 获得银行卡号
	User getCard(Integer u_id);
	
	// 用户添加银行卡
	int addCard(String u_card,Integer u_id);
	
	// 获取用户的地址信息
	List<Address> getUserAddr(Integer u_id);
	
	// 用户添加地址
	int addAddr(Address addr);
	
	// 用户删除地址
	int delAddr(@Param("a_id")Integer a_id);
	
	// 用户上传头像（存入数据库的是地址）
	int addPic(@Param("u_pic")String u_pic,@Param("u_id")Integer u_id);
}
