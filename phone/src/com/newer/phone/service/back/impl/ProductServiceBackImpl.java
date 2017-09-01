package com.newer.phone.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newer.phone.dao.ProductMapper;
import com.newer.phone.pojo.Image;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.back.ProductServiceBack;

public class ProductServiceBackImpl implements ProductServiceBack{
	
	@Autowired
	ProductMapper productMapper;
	@Override
	public int addProduct(Product product) {
		product.setP_status(1);
		return productMapper.addProduct(product);
	}

	@Override
	public int updateProduct(Integer p_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addImage(Image image) {
		
		return 0;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeProduct(Integer p_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
