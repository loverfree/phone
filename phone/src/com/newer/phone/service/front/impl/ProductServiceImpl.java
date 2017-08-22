package com.newer.phone.service.front.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.ProductMapper;
import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.front.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;
	
	//��ѯ������Ʒ�б�
	@Override
	public List<Product> getAllProduct() {
		List<Product> product = productMapper.findAllProduct();
		return product;
	}
	
	//������Ʒ����ѯ��Ʒ
	public List<Product> getByBrand(Integer b_id) {
		List<Product> products = productMapper.findByBrand(b_id);
		return products;
	}
	
	//������ƷID��ѯ��Ʒ��ϸ
	@Override
	public Product getById(Integer p_id) {
		Product product = productMapper.findById(p_id);
		return product;
	}
	
	//�����û�����Ĺؼ��ֽ���ģ����ѯ
	@Override
	public List<Product> findBySelect(String p_name) {
		String name = "%"+p_name+"%";
		List<Product> products = productMapper.findBySelect(name);
		return products;
	}
	
	//��ѯ������ƷƷ��
	@Override
	public List<Brand> getAllBrand() {
		List<Brand> brands = productMapper.findAllBrand();
		return brands;
	}
}
