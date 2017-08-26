package com.newer.phone.service.back;

import com.newer.phone.pojo.Product;

/**
 * 后台商品service层
 * @author Kiven
 *
 */
public interface ProductService {
	//添加商品
	int addProduct(Product product);
	
	//管理商品(包括修改删除  删除就是把商品状态p_status update为0)
	int updateProduct(Integer p_id);
}
