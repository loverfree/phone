package com.newer.phone.service.back;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.User;

/**
 * ��̨�û�����service��
 * @author Kiven
 *
 */
public interface UserServiceBack {
	//�鿴�����û�
	PageInfo<User> findUserAll(Integer pageNo,Integer pageSize);
	//�༭�û���Ϣ
	int updateUser(User user);
	//����id�����û�
	User getUserById(Integer u_id);
	
}
