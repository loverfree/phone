package com.newer.phone.service.front;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;
import com.newer.phone.pojo.Review;

public interface ProductService {
	
	
	//��ѯ������ƷƷ��
	PageInfo<Brand> getAllBrand(Integer pageNo,Integer pageSize);
	
	//������Ʒ����ѯ��Ʒ�б�
	PageInfo<Product> getByBrand(
			Integer b_id,
			String sort,String order,
			Integer pageNo,Integer pageSize,
			Integer start,Integer end);
	
	//��ѯ������Ʒ��������ģ����ѯ �Լ��۸�����
	PageInfo<Product> getAllProrduct(
			String p_name,
			String sort,String order,
			Integer pageNo,Integer pageSize,
			Integer start,Integer end);
	
	//������Ʒid��ѯ��Ʒ��ϸ
	Product getById(Integer p_id);
	
	//���Է�ҳ����
	PageInfo<Review> queryPage(Integer p_id,Integer pageNo,Integer pageSize);

}
