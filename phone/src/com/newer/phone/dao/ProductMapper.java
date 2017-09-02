package com.newer.phone.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;

/**
 * ��Ʒ��ϸ��dao��
 * @author Kiven
 *
 */
@Repository

public interface ProductMapper {
	//��ѯ������ƷƷ��
	List<Brand> findAllBrand();
	//��ѯ������Ʒ �����۸������Լ�ģ����ѯ�Լ�����
	List<Product> findAllProduct(
			@Param("p_name") String p_name,
			@Param("sort")String sort,
			@Param("order")String order,
			@Param("start")Integer start,
			@Param("end")Integer end);
	//������Ʒ����ѯ��Ʒ ��������
	List<Product> findByBrand(
			@Param("b_id")Integer b_id,
			@Param("sort")String sort,
			@Param("order")String order,
			@Param("start")Integer start,
			@Param("end")Integer end);
	//������Ʒid��ѯ��Ʒ��ϸ
	Product findById(@Param("p_id")Integer p_id);
	
	//������Ʒ
	int addProduct(Product product);
	
	//����Ʒ���ݽ����޸�
	int updateProduct(Product product);
	
	//����Ʒ����ɾ��������Ʒ״̬�޸�Ϊ0
	int removeProduct(@Param("p_id") Integer p_id);
	
	//����������Ʒ
	List<Product> getAllProduct();
	
	//���ݶ��������޸Ŀ���Լ�����
	int updateProductByAmount(@Param("c_amount")Integer c_amount,
			                  @Param("p_id")Integer p_id);
	
	//��ȡ���һ����Ʒid
	Integer findPid();
	
}
