package com.newer.phone.service.front;

import java.util.List;

import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;

public interface ProductService {
	
	//查询所有商品列表
	List<Product> getAllProduct(String p_name);
	
	//查询所有商品品牌
	List<Brand> getAllBrand();
	
	//根据商品类别查询商品列表
	List<Product> getByBrand(Integer b_id,String p_name,String sort,String order);
	
	//根据商品id查询商品详细
	Product getById(Integer p_id);
	
	//根据用户输入的关键字查询商品列表  如果没数据可能会抛出异常
	List<Product> findBySelect(String p_name);
}
