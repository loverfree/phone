package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.Image;
import com.newer.phone.pojo.Product;

/**
 * 后台商品service层
 * @author Kiven
 *
 */
public interface ProductServiceBack {
	//添加商品
	int addProduct(Product product);
	
	//管理商品(包括修改删除  删除就是把商品状态p_status update为0)
	int updateProduct(Integer p_id);
	
	List<Product> getAllProduct();
	
	int addImage(Image image);
	
	int removeProduct(Integer p_id);
}
