package com.newer.phone.service.back;

import com.newer.phone.pojo.Brand;

public interface BrandService {
	//添加类别
	int addBrand(Brand brand);
	//类别删除
	int removeBrand(Integer b_id);
}
