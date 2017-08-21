package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Product;

/**
 * ��Ʒ��ϸ��dao��
 * @author Kiven
 *
 */
@Repository

public interface ProductMapper {
	//��ѯ������Ʒ
	List<Product> findAllProduct();
	//������Ʒ����ѯ��Ʒ
	List<Product> findByBrand(@Param("b_id")Integer b_id);
	//������Ʒid��ѯ��Ʒ��ϸ
	Product findById(@Param("p_id")Integer p_id);
}
