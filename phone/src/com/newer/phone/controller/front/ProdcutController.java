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
		System.out.println("启动完成");
		List<Product> products = productService.getAllProduct();
		System.out.println(products.size());
		for(int i = 0;i < products.size();i++ ){
			System.out.println("商品名："+products.get(i).getP_name()+"---价格："+
					products.get(i).getP_price()+"--描述："+products.get(i).getP_info()+
					"--销量："+products.get(i).getP_sale()+"--图片："+products.get(i).getImages().get(0));
		}
		return "index";
	}
	@RequestMapping("/id")
	public String getByBrand(){
		List<Product> products = productService.getByBrand(2);
		for(int i = 0;i < products.size();i++ ){
			System.out.println("商品名："+products.get(i).getP_name()+"---价格："+
					products.get(i).getP_price()+"--描述："+products.get(i).getP_info()+
					"--销量："+products.get(i).getP_sale()+"--图片："+products.get(i).getImages().get(0));
		}
		return "index";
	}
	@RequestMapping("/aaa")
	public String getBId(){
		Product products = productService.getById(1);
			System.out.println("商品名："+products.getP_name()+"---价格："+
					products.getP_price()+"--描述："+products.getP_info()+
					"--销量："+products.getP_sale()+"--库存："+products.getP_stock()+
					"评论："+products.getReviews().get(0).getR_info()+"评论人："+
					"评论人："+products.getReviews().get(0).getUser().getU_name()+
					"评论时间"+products.getReviews().get(0).getR_time()+
					"--图片："+products.getImages().get(0));
		
		return "index";
	}
}
