package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.User;

/**
 * ��̨�û�����service��
 * @author Kiven
 *
 */
public interface UserService {
	//�鿴�����û�
	List<User> findAllUser();
	//�༭�û���Ϣ
	int updateCartByProduct(Integer u_id);
	
}
