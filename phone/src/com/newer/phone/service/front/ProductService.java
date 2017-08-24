package com.newer.phone.service.front;

import java.util.List;

import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;

public interface ProductService {
	
	//��ѯ������Ʒ�б�
	List<Product> getAllProduct(String p_name);
	
	//��ѯ������ƷƷ��
	List<Brand> getAllBrand();
	
	//������Ʒ����ѯ��Ʒ�б�
	List<Product> getByBrand(Integer b_id,String p_name,String sort,String order);
	
	//������Ʒid��ѯ��Ʒ��ϸ
	Product getById(Integer p_id);
	
	//�����û�����Ĺؼ��ֲ�ѯ��Ʒ�б�  ���û���ݿ��ܻ��׳��쳣
	List<Product> findBySelect(String p_name);
}
