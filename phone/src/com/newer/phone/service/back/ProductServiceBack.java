package com.newer.phone.service.back;

import java.util.List;

import com.github.pagehelper.PageInfo;
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
	int updateProduct(Product product);
	
	//�鿴ȫ����Ʒ
	PageInfo<Product> getProdcut(Integer pageNo,Integer pageSize);
	
	//���ͼƬ
	int addImage(Image image);
	
	//ɾ��һ����Ʒ
	int removeProduct(Integer p_id);
	
	Product selectProduct(Integer p_id);
	
	Integer findPid();
}
