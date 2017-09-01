package com.newer.phone.service.front.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	
	
	//������Ʒ����ѯ��Ʒ ����ѯ������Ʒ   �Լ�ģ����ѯ �Լ����ݼ۸���������������� 
	public PageInfo<Product> getByBrand(
			Integer b_id,
			String sort,String order,
			Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?6:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
		List<Product> products = productMapper.findByBrand(b_id,sort, order);
		PageInfo<Product> page = new PageInfo<Product>(products);
		return page;
	}
	
	@Override
	public PageInfo<Product> getAllProrduct(
			String p_name, String sort, 
			String order, Integer pageNo,
			Integer pageSize,
			Integer start,Integer end) {
		if (start == null || end  == null ) {
			start = 0;
			end = 1000000;
		}
		if (sort == null || sort == "") {
			sort = "p_price";
		}
		if (order == null || order == "") {
			order = "asc";
		}
		String name = null;
		if (p_name != null && p_name != "") {
			name = "%"+p_name+"%";
		}
		System.out.println(sort);
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?6:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
		List<Product> products = productMapper.findAllProduct(name,sort, order,start,end);
		PageInfo<Product> page = new PageInfo<Product>(products);
		return page;
	}
	
	//������ƷID��ѯ��Ʒ��ϸ
	@Override
	public Product getById(Integer p_id) {
		Product product = productMapper.findById(p_id);
		List<Image> images = imageMapper.getImage(p_id);
		List<Review> reviews = reviewMapper.getReview(p_id);
		System.out.println(reviews.size());
		product.setImages(images);
		product.setReviews(reviews);
		return product;
	}
	
	
	//��ѯ������ƷƷ��
	@Override
	public PageInfo<Brand> getAllBrand(Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?6:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Brand> list = productMapper.findAllBrand();
	    PageInfo<Brand> page = new PageInfo<Brand>(list);
		return page;
	}
	public PageInfo<Review> queryPage(Integer p_id,Integer pageNo,Integer pageSize){
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?1:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Review> reviews = reviewMapper.getReview(p_id);
	    PageInfo<Review> page = new PageInfo<Review>(reviews);
	    return page;
	}

}
