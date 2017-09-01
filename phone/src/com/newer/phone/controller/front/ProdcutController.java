package com.newer.phone.controller.front;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;
import com.newer.phone.pojo.Review;
import com.newer.phone.service.front.ProductService;

@Controller
@RequestMapping("product")
public class ProdcutController {
	@Autowired
	private ProductService productService;

	/**
	 * 根据商品品牌查询商品列表
	 * 
	 * @return
	 * @time:2017年8月22日 上午10:24:49
	 */
	@RequestMapping(value = "/{b_id}/list")
	public String getByBrand(
			@PathVariable Integer b_id,
			Integer pageNo, Integer pageSize,
			String sort,String order,
			Model model){
		
		PageInfo<Product> page = productService.getByBrand(
				b_id,sort, order, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("bid",b_id);
		List<Product> products=page.getList(); 
		for(int i = 0;i < products.size();i++ ){
			System.out.println("商品名："+products.get(i).getP_name()+"---价格："+
					products.get(i).getP_price()+"--描述："+products.get(i).getP_info()+
					"--销量："+products.get(i).getP_sale()+"--图片："+products.get(i).getP_image());
		}
		return "product";
	}
	
	
	@RequestMapping(value = "/fuzzy/list")
	public String getAll(
			@RequestParam(value="pname",required=false) String pname,
			Integer pageNo, Integer pageSize,
			Integer start,Integer end,
			String sort,String order,
			Model model){

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
		/*			"评论："+products.getReviews().get(0).getR_info()+
					"评论人："+products.getReviews().get(0).getUser().getU_name()+
					"评论时间"+products.getReviews().get(0).getR_time()+*/
					"--图片："+products.getImages().get(0).getI_path()+
					"图片个数："+products.getImages().size());
		
		return "productdetails";
	}
	@RequestMapping(value = "/product/review")
	public String getViews(Integer p_id ,Integer pageNo, Integer pageSize){
		
		
		return "productdetails";
	}
    @RequestMapping("/positionlistajax")
    public @ResponseBody Map<String, Object> getView(Model model,
            @RequestParam(value = "pagesize", required = false, defaultValue = "1") int pagesize,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo){
    	System.out.println("进入方法");
    	 Map<String, Object> map = new HashMap<String, Object>();  
       PageInfo<Review> page = productService.queryPage(4,pageNo, pagesize);
       List<Review> review=page.getList();
       System.out.println(pageNo+ "---"+pagesize);
       System.out.println("size"+review.size());
       map.put("review", review);;
       
        return map;
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
}
