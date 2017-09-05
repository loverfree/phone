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
import com.newer.phone.pojo.Inform;
import com.newer.phone.pojo.User;
@Repository
public interface UserMapper {

	// ��ȡ�û���Ϣ�����,�ж��û��Ƿ����
	User chkUser(@Param("u_name")String u_name);
	
	// �û�ע��
	int regUser(User user);
	
	// �û���¼
	User loginUser(@Param("u_name")String u_name,@Param("u_pwd")String u_pwd);
	
	// ��¼�����id����û���Ϣ
	User getUserInfo(@Param("u_id")Integer u_id);
	
	// �û��޸��Լ�����Ϣ
	int updateUser(User user);
	
	// ������п���
	User getCard(@Param("u_id")Integer u_id);
	
	// �û�������п�
	int addCard(@Param("u_card")String u_card,@Param("u_id")Integer u_id);
	
	// ��ȡ�û��ĵ�ַ��Ϣ
	List<Address> getUserAddr(@Param("u_id")Integer u_id);

	// �û���ӵ�ַ
	int addAddr(Address addr);
	
	// �û�ɾ����ַ
	int delAddr(@Param("a_id")Integer a_id);
	
	// �û��ϴ�ͷ�񣨴������ݿ���ǵ�ַ��
	int addPic(@Param("u_pic")String u_pic,@Param("u_id")Integer u_id);
	
	List<User> findUserAll();

	User getUserById(Integer u_id);
	
	//���ȷ���ջ���֪ͨ
	List<Inform> getInform(Integer u_id);
}
