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
	@RequestMapping("/")
	public String test(){
		System.out.println("Æô¶¯Íê³É");
		List<Product> products = productService.getAllProduct();
		for(int i = 0;i < products.size();i++ ){
			System.out.println(products.get(i).getP_name()+"---"+products.get(i).getP_price());
		}
		return "index";
	}
}
