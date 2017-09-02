package com.newer.phone.service.front;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newer.phone.pojo.Address;
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
	
	// ��ȡ�û��ĵ�ַ��Ϣ
	List<Address> getUserAddr(Integer u_id);
	
	// �û���ӵ�ַ
	int addAddr(Address addr);
	
	// �û�ɾ����ַ
	int delAddr(@Param("a_id")Integer a_id);
	
	// �û��ϴ�ͷ�񣨴������ݿ���ǵ�ַ��
	int addPic(@Param("u_pic")String u_pic,@Param("u_id")Integer u_id);
}
