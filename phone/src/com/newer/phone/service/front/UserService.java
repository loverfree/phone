package com.newer.phone.service.front;

import com.newer.phone.pojo.User;

public interface UserService {

	// ��ȡ�û���Ϣ�����
	User chkUser(String u_name);
	
	// �û�ע��
	int regUser(String u_name,String u_pwd);
	
	// ��֤�û��Ƿ����
	User loginUser(String u_name,String u_pwd);
	
	// �û��޸��Լ�����Ϣ
	int updateUser(User user);
	
}
