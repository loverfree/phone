package com.newer.phone.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * �û�dao��
 * @author Kiven
 *
 */

import com.newer.phone.pojo.User;
@Repository
public interface UserMapper {

	// ��ȡ�û���Ϣ�����,�ж��û��Ƿ����
	User chkUser(@Param("u_name")String u_name);
	
	// �û�ע��
	int regUser(User user);
	
	// �û���¼
	User loginUser(@Param("u_name")String u_name,@Param("u_pwd")String u_pwd);
}
