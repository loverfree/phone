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
	//查询所有商品 包含价格搜索以及模糊查询以及排序
	List<Product> findAllProduct(
			@Param("p_name") String p_name,
			@Param("sort")String sort,
			@Param("order")String order,
			@Param("start")Integer start,
			@Param("end")Integer end);
	//根据商品类别查询商品 包含排序
	List<Product> findByBrand(
			@Param("b_id")Integer b_id,
			@Param("sort")String sort,
			@Param("order")String order,
			@Param("start")Integer start,
			@Param("end")Integer end);
	//根据商品id查询商品详细
	Product findById(@Param("p_id")Integer p_id);
	
	//增加商品
	int addProduct(Product product);
	
	//对商品内容进行修改
	int updateProduct(Product product);
	
	//对商品进行删除即将商品状态修改为0
	int removeProduct(@Param("p_id") Integer p_id);
	
	//插叙所有商品
	List<Product> getAllProduct();
	
	//根据订单数量修改库存以及销量
	int updateProductByAmount(@Param("c_amount")Integer c_amount,
			                  @Param("p_id")Integer p_id);
	
	//获取最后一个商品id
	Integer findPid();
	
}
