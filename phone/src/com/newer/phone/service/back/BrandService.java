package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.Brand;

public interface BrandService {
	//������
	int addBrand(Brand brand);
	//���ɾ��
	int removeBrand(Integer b_id);
	//�鿴�������
	List<Brand> getAllBrand();
}
