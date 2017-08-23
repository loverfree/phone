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
	 * ��̨�������Ʒ���͵���ӣ�ǰ�˴��������������������logo��״̬�ɷ����ȥ��װ��
	 * @param brand
	 * @return
	 * @author samluby
	 */
	@RequestMapping("addBrand")
	public String addBrand(Brand brand){
		brand.setB_name("�ȸ�");
		brand.setB_logo("�ȸ�ͼƬ");
		brand.setB_status(1);
		int isTrue = brandService.addBrand(brand);
		System.out.println(isTrue);
		return "index";
	}
	
	/**
	 * ��̨��Ʒ���͵�ɾ�������������id��ִ��sql��䣬���������ݿ����delete�����update�����ɾ����
	 * ��������״̬b_status��1(�ϼ�)����Ϊ0(�¼�)
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
