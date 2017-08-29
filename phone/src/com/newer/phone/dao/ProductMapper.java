package com.newer.phone.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;

/**
 * 商品详细的dao层
 * @author Kiven
 *
 */
@Repository

public interface ProductMapper {
	//查询所有商品品牌
	List<Brand> findAllBrand();
	//查询所有商品
	List<Product> findAllProduct(
			@Param("p_name") String p_name,
			@Param("sort")String sort,
			@Param("order")String order,
			@Param("start")Integer start,
			@Param("end")Integer end);
	//根据商品类别查询商品
	List<Product> findByBrand(
			@Param("b_id")Integer b_id,
			@Param("p_name")String p_name,
			@Param("sort")String sort,
			@Param("order")String order);
	//根据商品id查询商品详细
	Product findById(@Param("p_id")Integer p_id);
	//根据用户输入的关键字进行模糊查询
	List<Product> findBySelect(@Param("p_name")String p_name);
}
