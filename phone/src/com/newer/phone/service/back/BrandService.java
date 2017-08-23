package com.newer.phone.service.back;

import com.newer.phone.pojo.Brand;

public interface BrandService {

	int addBrand(Brand brand);
	
	int removeBrand(Integer b_id);
}
