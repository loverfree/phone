package com.newer.phone.service.front;

import java.util.List;

import com.newer.phone.pojo.Product;

public interface ProductService {
	List<Product> getAllProduct();
	List<Product> getByBrand(Integer b_id);
	Product getById(Integer p_id);
}
