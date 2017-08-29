package com.newer.phone.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * �û�dao��
 * @author Kiven
 *
 */

import com.newer.phone.pojo.Address;
import com.newer.phone.pojo.User;
@Repository
public interface UserMapper {

	// ��ȡ�û���Ϣ�����,�ж��û��Ƿ����
	User chkUser(@Param("u_name")String u_name);
	
	// �û�ע��
	int regUser(User user);
	
	// �û���¼
	User loginUser(@Param("u_name")String u_name,@Param("u_pwd")String u_pwd);
	
	// �û��޸��Լ�����Ϣ
	int updateUser(User user);
	
	// ��ȡ�û��ĵ�ַ��Ϣ
	List<Address> getUserAddr(@Param("u_id")Integer u_id);

	List<User> findUserAll();

	User getUserById(Integer u_id);
}
