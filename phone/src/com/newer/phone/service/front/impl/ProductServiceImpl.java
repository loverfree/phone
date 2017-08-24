package com.newer.phone.service.front.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.ImageMapper;
import com.newer.phone.dao.ProductMapper;
import com.newer.phone.dao.ReviewMapper;
import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Image;
import com.newer.phone.pojo.Product;
import com.newer.phone.pojo.Review;
import com.newer.phone.service.front.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private ReviewMapper reviewMapper;
	
	//查询所有商品列表
	@Override
	public List<Product> getAllProduct(String p_name) {
		String name = null;
		if(p_name != null && p_name != "") {
			name = "%"+p_name+"%";
		}
		List<Product> product = productMapper.findAllProduct(name);
		return product;
	}
	
	//根据商品类别查询商品
	public List<Product> getByBrand(Integer b_id,String p_name,String sort,String order) {
		String name = null;
		if (p_name != null && p_name != "") {
			name = "%"+p_name+"%";
		}
		System.out.println("----------"+name);
		List<Product> products = productMapper.findByBrand(b_id,name,sort, order);
		
		return products;
	}
	
	//根据商品ID查询商品详细
	@Override
	public Product getById(Integer p_id) {
		Product product = productMapper.findById(p_id);
		List<Image> images = imageMapper.getImage(p_id);
		List<Review> reviews = reviewMapper.getReview(p_id);
		product.setImages(images);
		product.setReviews(reviews);
		return product;
	}
	
	//根据用户输入的关键字进行模糊查询
	@Override
	public List<Product> findBySelect(String p_name) {
		String name = "%"+p_name+"%";
		List<Product> products = productMapper.findBySelect(name);
		return products;
	}
	
	//查询所有商品品牌
	@Override
	public List<Brand> getAllBrand() {
		List<Brand> brands = productMapper.findAllBrand();
		return brands;
	}
}
