package com.newer.phone.controller.back;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.newer.phone.pojo.Brand;
import com.newer.phone.service.back.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	/**
	 * 测试
	 * @return
	 * @author samluby
	 */
	@RequestMapping("goadd")
	public String goadd(){
		return "addBrand";
	}
	
	/**
	 * 后台管理对商品类型的添加，前端传入参数，类型名，类型logo。状态由服务层去封装。
	 * @param brand
	 * @return
	 * @author samluby
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="addBrand",method=RequestMethod.POST)
	public String addBrand(@RequestParam("b_name")String b_name,
			               @RequestParam("b_logo")MultipartFile file,
			               HttpServletRequest request) throws IllegalStateException, IOException{
		String fileName = file.getOriginalFilename()+UUID.randomUUID();
		File dest = new File(fileName);
		System.out.println(file.getContentType());
		file.transferTo(dest);
		Brand brand = new Brand();
		brand.setB_name(b_name);
		brand.setB_logo(fileName);
		brandService.addBrand(brand);
		System.out.println("OK");
		return "redirect:list";
	}
	
	/**
	 * 后台商品类型的删除管理，根据类别id来执行sql语句，但不对数据库进行delete语语。用update语句来删除，
	 * 集将类别的状态b_status从1(上架)更新为0(下架)
	 * @param b_id
	 * @return
	 * @author samluby
	 */
	@RequestMapping("removeBrand/{b_id}")
	public String removeBrand(@PathVariable("b_id")Integer b_id){
		int isTrue = brandService.removeBrand(b_id);
		System.out.println(isTrue);
		return "redirect:../list";
	}
	
	/**
	 * 查看所有类型
	 * @param model
	 * @return
	 * @author samluby
	 */
	@RequestMapping("list")
	public String getAllBrand(Model model){
	    List<Brand> list = brandService.getAllBrand();
	    model.addAttribute("brands", list);
		return "brandAll";
	}
	
}
