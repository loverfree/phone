package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.Image;
import com.newer.phone.pojo.Product;

/**
 * ��̨��Ʒservice��
 * @author Kiven
 *
 */
public interface ProductServiceBack {
	//�����Ʒ
	int addProduct(Product product);
	
	//������Ʒ(�����޸�ɾ��  ɾ�����ǰ���Ʒ״̬p_status updateΪ0)
	int updateProduct(Integer p_id);
	
	List<Product> getAllProduct();
	
	int addImage(Image image);
	
	int removeProduct(Integer p_id);
}
