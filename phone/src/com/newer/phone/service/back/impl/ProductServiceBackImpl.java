package com.newer.phone.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.phone.dao.ImageMapper;
import com.newer.phone.dao.ProductMapper;
import com.newer.phone.pojo.Image;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.back.ProductServiceBack;

@Service
public class ProductServiceBackImpl implements ProductServiceBack{
	
	@Autowired
	ProductMapper productMapper;
	@Autowired 
	ImageMapper imageMapper;
	
	@Override
	public int addProduct(Product product) {
		product.setP_status(1);
		return productMapper.addProduct(product);
	}

	@Override
	public int updateProduct(Product product) {
		return productMapper.updateProduct(product);
	}

	@Override
	public int addImage(Image image) {
		return imageMapper.addImage(image);
	}

	@Override
	public PageInfo<Product> getProdcut(Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null ? 1:pageNo;
		pageSize = pageSize == null? 6:pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Product> list = productMapper.getAllProduct();
		PageInfo<Product> page= new PageInfo<Product>(list);
		return page;
		
	}

	@Override
	public int removeProduct(Integer p_id) {
		return productMapper.removeProduct(p_id);
	}

	@Override
	public Product selectProduct(Integer p_id) {
		Product product = productMapper.findById(p_id);
		return product;
	}
	
}
