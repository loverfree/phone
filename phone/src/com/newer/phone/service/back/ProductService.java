package com.newer.phone.service.back;

import com.newer.phone.pojo.Product;

/**
 * ��̨��Ʒservice��
 * @author Kiven
 *
 */
public interface ProductService {
	//�����Ʒ
	int addProduct(Product product);
	
	//������Ʒ(�����޸�ɾ��  ɾ�����ǰ���Ʒ״̬p_status updateΪ0)
	int updateProduct(Integer p_id);
}
