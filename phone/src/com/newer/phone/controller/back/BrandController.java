package com.newer.phone.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.phone.pojo.Brand;
import com.newer.phone.service.back.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	/**
	 * 后台管理对商品类型的添加，前端传入参数，类型名，类型logo。状态由服务层去封装。
	 * @param brand
	 * @return
	 * @author samluby
	 */
	@RequestMapping("addBrand")
	public String addBrand(Brand brand){
		brand.setB_name("谷歌");
		brand.setB_logo("谷歌图片");
		brand.setB_status(1);
		int isTrue = brandService.addBrand(brand);
		System.out.println(isTrue);
		return "index";
	}
	
	/**
	 * 后台商品类型的删除管理，根据类别id来执行sql语句，但不对数据库进行delete语语。用update语句来删除，
	 * 集将类别的状态b_status从1(上架)更新为0(下架)
	 * @param b_id
	 * @return
	 * @author samluby
	 */
	@RequestMapping("removeBrand")
	public String removeBrand(Integer b_id){
		b_id = 4;
		int isTrue = brandService.removeBrand(b_id);
		System.out.println(isTrue);
		return "index";
	}
	
}
