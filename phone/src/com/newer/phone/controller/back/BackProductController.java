package com.newer.phone.controller.back;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Image;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.back.ProductServiceBack;

@Controller
@RequestMapping("/product")
public class BackProductController {
	@Autowired
	ProductServiceBack productServiceBack;
	
	@RequestMapping("/backlist")
	public String listProduct(
			Integer pageNo,Integer pageSize,
			Model model){
		PageInfo<Product> page = productServiceBack.getProdcut(pageNo, pageSize);
		System.out.println(pageNo);
		model.addAttribute("page", page);
		System.out.println("page"+page);

		return "listProduct";
		
	}
	
	@RequestMapping("/addProduct/{b_id}")
	public String add(@PathVariable("b_id")Integer b_id,Model model){
		model.addAttribute("b_id", b_id);
		return "addProduct";
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(Integer b_id,
							String p_name,BigDecimal p_import,
							BigDecimal p_price,Integer p_stock,
							Integer p_sale,String p_info,
							@RequestParam("p_image")MultipartFile[] file,
							HttpServletRequest request) throws IllegalStateException, IOException{  
        List<String> listImagePath=new ArrayList<String>();
        Product product = new Product();
        Brand brand = new Brand();
        brand.setB_id(b_id);
        product.setP_name(p_name);
        product.setBrand(brand);
        product.setP_import(p_import);
        product.setP_price(p_price);
        product.setP_stock(p_stock);
        product.setP_sale(p_sale);
        product.setP_info(p_info);
        Image image = new Image();
        String path = "resources/image/";
        String pString = request.getSession().getServletContext().getRealPath("image");
        for(Integer i = 0;i < file.length;i++) {  
      
            	String fileName = UUID.randomUUID()+file[i].getOriginalFilename();  
                //获得文件后缀名称  
            	File dest = new File(pString,fileName); 
            	file[i].transferTo(dest);
            	String u_pic = path + fileName;
            	
            	if (i == 0) {
					product.setP_image(u_pic);
					productServiceBack.addProduct(product);
				}
            	Integer pid = productServiceBack.findPid();
            	product.setP_id(pid);
            	image.setProduct(product);
            	image.setI_path(u_pic);
            	 productServiceBack.addImage(image);
        }  

		return "redirect:backlist";
	}
	
	
	@RequestMapping("/{p_id}/updateProduct")
	public String updateProduct(@PathVariable("p_id") Integer p_id,Model model){
		Product product = productServiceBack.selectProduct(p_id);
		System.out.println(product.getP_import());
		model.addAttribute("product", product);
		
		return "updateProduct";
		
	}
	
	@RequestMapping("/{p_id}/remove")
	public String removeProduct(@PathVariable("p_id") Integer p_id){
		System.out.println("jinlai l ");
		int result = productServiceBack.removeProduct(p_id);
		System.out.println(result);

		
		return "redirect:../backlist";
		
	}
	
	@RequestMapping("/saveProduct")
	public String saceProduct(@ModelAttribute("product") Product product,Model model){
		int result = productServiceBack.updateProduct(product);
		System.out.println(result);
		return "redirect:backlist";
		
	}
}
