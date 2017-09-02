package com.newer.phone.service.back;

import java.util.List;

import com.github.pagehelper.PageInfo;
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
	int updateProduct(Product product);
	
	//查看全部商品
	PageInfo<Product> getProdcut(Integer pageNo,Integer pageSize);
	
	//添加图片
	int addImage(Image image);
	
	//删除一个商品
	int removeProduct(Integer p_id);
	
	Product selectProduct(Integer p_id);
	
	Integer findPid();
}
