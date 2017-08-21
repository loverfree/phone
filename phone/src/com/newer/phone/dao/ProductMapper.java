package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Product;

/**
 * 商品详细的dao层
 * @author Kiven
 *
 */
@Repository

public interface ProductMapper {
	//查询所有商品
	List<Product> findAllProduct();
	//根据商品类别查询商品
	List<Product> findByBrand(@Param("b_id")Integer b_id);
	//根据商品id查询商品详细
	Product findById(@Param("p_id")Integer p_id);
}
