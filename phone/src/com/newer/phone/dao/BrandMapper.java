package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newer.phone.pojo.Brand;

public interface BrandMapper {

	/**
	 * 添加商品的类别
	 * @param brand  商品类别实体对象
	 * @return
	 * @author samluby
	 */
	int addBrand(Brand brand);
	
	/**
	 * 商品类别的删除，不对数据库进行删除 ，只是将状态更新为0(下架)
	 * @param b_id
	 * @return
	 * @author samluby
	 */
	int removeBrand(@Param("b_id")Integer b_id);
	
	/**
	 * 查看所有商品的类别
	 * @return
	 * @author samluby
	 */
	List<Brand> getAllBrand();

}
