package com.newer.phone.service.front;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;
import com.newer.phone.pojo.Review;

public interface ProductService {
	
	
	//查询所有商品品牌
	PageInfo<Brand> getAllBrand(Integer pageNo,Integer pageSize);
	
	//根据商品类别查询商品列表
	PageInfo<Product> getByBrand(
			Integer b_id,
			String sort,String order,
			Integer pageNo,Integer pageSize,
			Integer start,Integer end);
	
	//查询所有商品包括排序模糊查询 以及价格搜索
	PageInfo<Product> getAllProrduct(
			String p_name,
			String sort,String order,
			Integer pageNo,Integer pageSize,
			Integer start,Integer end);
	
	//根据商品id查询商品详细
	Product getById(Integer p_id);
	
	//测试分页方法
	PageInfo<Review> queryPage(Integer p_id,Integer pageNo,Integer pageSize);

}
