package com.newer.phone.controller.front;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.front.ProductService;

@Controller
@RequestMapping("product")
public class ProdcutController {
	@Autowired
	private ProductService productService;
	private String sort = "p_price";
	private String order = "desc" ;
	
	/**
	 * 查询所有商品列表
	 * @return  返回主页面
	 * @time:2017年8月22日 上午10:24:24
	 */
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
	
	/**
	 * 根据商品品牌查询商品列表
	 * @return
	 * @time:2017年8月22日 上午10:24:49
	 */
	@RequestMapping(value = "/{b_id}/list",method = RequestMethod.GET)
	public String getByBrand(@PathVariable int b_id,Model model){
		List<Product> products = productService.getByBrand(b_id, sort, order);
		model.addAttribute("products", products);
		for(int i = 0;i < products.size();i++ ){
			System.out.println("商品名："+products.get(i).getP_name()+"---价格："+
					products.get(i).getP_price()+"--描述："+products.get(i).getP_info()+
					"--销量："+products.get(i).getP_sale()+"--图片：");
		}
		//
		return "product";
	}
	
	/**
	 * 根据商品id查询商品详细内容
	 * @return
	 * @time:2017年8月22日 上午10:25:41
	 */
	@RequestMapping(value = "/{p_id}/details",method = RequestMethod.GET)
	public String getById(@PathVariable int p_id,Model model){
		Product products = productService.getById(p_id);
		model.addAttribute("details", products);
			System.out.println("商品名："+products.getP_name()+"---价格："+
					products.getP_price()+"--描述："+products.getP_info()+
					"--销量："+products.getP_sale()+"--库存："+products.getP_stock()+
					"评论："+products.getReviews().get(0).getR_info()+"评论人："+
					"评论人："+products.getReviews().get(0).getUser().getU_name()+
					"评论时间"+products.getReviews().get(0).getR_time()+
					"--图片："+products.getImages().get(0).getI_path()+
					"图片个数："+products.getImages().size());
		
		return "productdetails";
	}
	/**
	 * 根据关键字进行模糊查询
	 * @return
	 * @time:2017年8月22日 上午10:27:33
	 */
	@RequestMapping(value = "/fuzzy",method = RequestMethod.POST)
	public String getBySelect(String pname){
		List<Product> products = productService.findBySelect(pname);
		System.out.println(pname);
		for(int i = 0;i < products.size();i++ ){
			System.out.println("商品名："+products.get(i).getP_name()+"---价格："+
					products.get(i).getP_price()+"--描述："+products.get(i).getP_info()+
					"--销量："+products.get(i).getP_sale()+"--图片："+products.get(i).getImages().get(0));
		}
		return "index";
	}
	/**
	 * 查询所有商品的品牌
	 * @return
	 * @time:2017年8月22日 上午10:40:01
	 */
	@RequestMapping("brand")
	public String getAllBrand(Model model){
		List<Brand> brands = productService.getAllBrand();
		model.addAttribute("brands",brands);
		for(int i = 0;i < brands.size();i++){
			System.out.println("品牌名："+brands.get(i).getB_name()+"--品牌图片："+
					brands.get(i).getB_logo());
		}
		//
		int total = brands.size();
		int line = total%3==0?total/3:total/3+1;
		model.addAttribute("line", line);
		return "index";
	}
}
