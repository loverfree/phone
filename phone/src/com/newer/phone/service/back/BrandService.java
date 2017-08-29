package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.Brand;

public interface BrandService {
	//添加类别
	int addBrand(Brand brand);
	//类别删除
	int removeBrand(Integer b_id);
	//查看所有类别
	List<Brand> getAllBrand();
}
