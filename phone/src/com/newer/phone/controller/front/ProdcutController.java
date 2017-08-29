package com.newer.phone.controller.front;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.front.ProductService;

@Controller
@RequestMapping("product")
public class ProdcutController {
	@Autowired
	private ProductService productService;
//	private String sort = "p_price";
//	private String order = "desc" ;
	
	

	/**
	 * 根据商品品牌查询商品列表
	 * 
	 * @return
	 * @time:2017年8月22日 上午10:24:49
	 */
	@RequestMapping(value = "/{b_id}/list")
	public String getByBrand(
			@PathVariable Integer b_id,
			@RequestParam(value="pname",required=false) String pname,
			Integer pageNo, Integer pageSize,
			String sort,String order,
			Model model){
		
		PageInfo<Product> page = productService.getByBrand(
				b_id, pname,sort, order, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("bid",b_id);
		System.out.println("--------page"+page);
		System.out.println(sort);
		List<Product> products=page.getList(); 
		for(int i = 0;i < products.size();i++ ){
			System.out.println("商品名："+products.get(i).getP_name()+"---价格："+
					products.get(i).getP_price()+"--描述："+products.get(i).getP_info()+
					"--销量："+products.get(i).getP_sale()+"--图片："+products.get(i).getP_image());
		}
		return "product";
	}
	
	
	
	@RequestMapping(value = "/fuzzy/list")
	public String getA(

			@RequestParam(value="pname",required=false) String pname,
			Integer pageNo, Integer pageSize,
			Integer start,Integer end,
			String sort,String order,
			Model model){
		
		System.out.println(sort);
		System.out.println(order);
		System.out.println(pname);
		PageInfo<Product> page = productService.getAllProrduct(
				pname,sort, order,pageNo, pageSize,start,end);
	
		model.addAttribute("page", page);
		model.addAttribute("pname",pname);
		List<Product> products=page.getList();
		
		for(int i = 0;i < products.size();i++ ){
			System.out.println(products.get(i).getP_id()+"商品名："+products.get(i).getP_name()+"---价格："+
					products.get(i).getP_price()+"--描述："+products.get(i).getP_info()+
					"--销量："+products.get(i).getP_sale()+"--图片："+products.get(i).getP_image());
		}
		return "productfuzzy";
	} 
	
	
	/**
	 * 根据商品id查询商品详细内容
	 * @return
	 * @time:2017年8月22日 上午10:25:41
	 */
	@RequestMapping(value = "/{p_id}/details",method = RequestMethod.GET)
	public String getById(@PathVariable Integer p_id,Model model){
		Product products = productService.getById(p_id);
		model.addAttribute("details", products);
			System.out.println("商品id:"+products.getP_id()+"商品名："+products.getP_name()+"---价格："+
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
	 * 查询所有商品的品牌
	 * @return
	 * @time:2017年8月22日 上午10:40:01
	 */
	@RequestMapping("/brand/list")
	public String getAllBrand(Model model,Integer pageNo, Integer pageSize){
		PageInfo<Brand> page =  productService.getAllBrand(pageNo, pageSize);
		List<Brand> brands = page.getList();
		model.addAttribute("page",page);
		model.addAttribute("brands", brands);
		System.out.println("------------page"+page);
		for(int i = 0;i < brands.size();i++){
			System.out.println("品牌名："+brands.get(i).getB_name()+"--品牌图片："+
					brands.get(i).getB_logo());
		}
		return "index";
	}
//	@RequestMapping("test")
//	public String queryByPageTest(){
//		PageInfo<Brand> page = productService.queryPage(1,3);
//		List<Brand> list = page.getList();
//		System.out.println("------------page"+list.size());
//		return "index";
//	}
}
