package com.newer.phone.service.back.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.BrandMapper;
import com.newer.phone.pojo.Brand;
import com.newer.phone.service.back.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandMapper brandMapper;

	@Override
	public int addBrand(Brand brand) {
		return brandMapper.addBrand(brand);
	}

	/**
	 * 商品类别的删除，不对数据库进行删除 ，只是将状态更新为0(下架)
	 * @param b_id
	 * @return
	 * @author samluby
	 */
	@Override
	public int removeBrand(Integer b_id) {
		return brandMapper.removeBrand(b_id);
	}

}
