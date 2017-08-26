package com.newer.phone.service.front.impl;


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
			Integer b_id,String p_name,
			String sort,String order,
			Integer pageNo,Integer pageSize) {
		String name = null;
		if (p_name != null && p_name != "") {
			name = "%"+p_name+"%";
		}
		
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?1:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
		List<Product> products = productMapper.findByBrand(b_id,name,sort, order);
//		System.out.println("----------"+products.get(0).getBrand().getB_id());
		PageInfo<Product> page = new PageInfo<Product>(products);
		return page;
	}
	
	@Override
	public PageInfo<Product> getAllProrduct(String p_name, String sort, String order, Integer pageNo,
			Integer pageSize) {
		String name = null;
		if (p_name != null && p_name != "") {
			name = "%"+p_name+"%";
		}
		System.out.println("----------"+name);
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?3:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
		List<Product> products = productMapper.findAllProduct(name,sort, order);
		System.out.println("--======="+products.get(0).getP_id());
		PageInfo<Product> page = new PageInfo<Product>(products);
		return page;
	}
	
	//������ƷID��ѯ��Ʒ��ϸ
	@Override
	public Product getById(Integer p_id) {
		Product product = productMapper.findById(p_id);
		List<Image> images = imageMapper.getImage(p_id);
		List<Review> reviews = reviewMapper.getReview(p_id);
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
	
	//���Է�ҳ����
	@Override
	public PageInfo<Brand> queryPage(Integer pageNo, Integer pageSize) {
		 	pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?6:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Brand> list = productMapper.findAllBrand();
		    //��PageInfo�Խ�����а�װ
		    PageInfo<Brand> page = new PageInfo<Brand>(list);
		    
		    //����PageInfoȫ������
		    System.out.println("--------------");
		    for(Brand brand:list){
		    	System.out.println(brand.getB_name()+"--"+brand.getB_logo());
		    }
		    System.out.println(page.getPageNum());
		    System.out.println(page.getPageSize());
		    System.out.println(page.getStartRow());
		    System.out.println(page.getEndRow());
		    System.out.println(page.getTotal());
		    System.out.println(page.getPages());
		    System.out.println(page.getFirstPage());
		    System.out.println(page.getLastPage());
		    System.out.println(page.isHasPreviousPage());
		    System.out.println(page.isHasNextPage());
		    return page;
	}


}
