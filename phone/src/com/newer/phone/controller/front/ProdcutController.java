package com.newer.phone.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.phone.pojo.Product;
import com.newer.phone.service.front.ProductService;

@Controller
@RequestMapping("product")
public class ProdcutController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/all")
	public String getAllProduct(){
		System.out.println("�������");
		List<Product> products = productService.getAllProduct();
		System.out.println(products.size());
		for(int i = 0;i < products.size();i++ ){
			System.out.println("��Ʒ����"+products.get(i).getP_name()+"---�۸�"+
					products.get(i).getP_price()+"--������"+products.get(i).getP_info()+
					"--������"+products.get(i).getP_sale()+"--ͼƬ��"+products.get(i).getImages().get(0));
		}
		return "index";
	}
	@RequestMapping("/id")
	public String getByBrand(){
		List<Product> products = productService.getByBrand(2);
		for(int i = 0;i < products.size();i++ ){
			System.out.println("��Ʒ����"+products.get(i).getP_name()+"---�۸�"+
					products.get(i).getP_price()+"--������"+products.get(i).getP_info()+
					"--������"+products.get(i).getP_sale()+"--ͼƬ��"+products.get(i).getImages().get(0));
		}
		return "index";
	}
	@RequestMapping("/aaa")
	public String getBId(){
		Product products = productService.getById(1);
			System.out.println("��Ʒ����"+products.getP_name()+"---�۸�"+
					products.getP_price()+"--������"+products.getP_info()+
					"--������"+products.getP_sale()+"--��棺"+products.getP_stock()+
					"���ۣ�"+products.getReviews().get(0).getR_info()+"�����ˣ�"+
					"�����ˣ�"+products.getReviews().get(0).getUser().getU_name()+
					"����ʱ��"+products.getReviews().get(0).getR_time()+
					"--ͼƬ��"+products.getImages().get(0));
		
		return "index";
	}
}
