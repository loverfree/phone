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
	//��ѯ������Ʒ
	List<Product> findAllProduct(
			@Param("p_name") String p_name,
			@Param("sort")String sort,
			@Param("order")String order,
			@Param("start")Integer start,
			@Param("end")Integer end);
	//������Ʒ����ѯ��Ʒ
	List<Product> findByBrand(
			@Param("b_id")Integer b_id,
			@Param("p_name")String p_name,
			@Param("sort")String sort,
			@Param("order")String order);
	//������Ʒid��ѯ��Ʒ��ϸ
	Product findById(@Param("p_id")Integer p_id);
	//�����û�����Ĺؼ��ֽ���ģ����ѯ
	List<Product> findBySelect(@Param("p_name")String p_name);
}
