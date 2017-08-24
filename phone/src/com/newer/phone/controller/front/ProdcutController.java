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
	 * ��ѯ������Ʒ�б�
	 * @return  ������ҳ��
	 * @time:2017��8��22�� ����10:24:24
	 */
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
	
	/**
	 * ������ƷƷ�Ʋ�ѯ��Ʒ�б�
	 * @return
	 * @time:2017��8��22�� ����10:24:49
	 */
	@RequestMapping(value = "/{b_id}/list",method = RequestMethod.GET)
	public String getByBrand(@PathVariable int b_id,Model model){
		List<Product> products = productService.getByBrand(b_id, sort, order);
		model.addAttribute("products", products);
		for(int i = 0;i < products.size();i++ ){
			System.out.println("��Ʒ����"+products.get(i).getP_name()+"---�۸�"+
					products.get(i).getP_price()+"--������"+products.get(i).getP_info()+
					"--������"+products.get(i).getP_sale()+"--ͼƬ��");
		}
		//
		return "product";
	}
	
	/**
	 * ������Ʒid��ѯ��Ʒ��ϸ����
	 * @return
	 * @time:2017��8��22�� ����10:25:41
	 */
	@RequestMapping(value = "/{p_id}/details",method = RequestMethod.GET)
	public String getById(@PathVariable int p_id,Model model){
		Product products = productService.getById(p_id);
		model.addAttribute("details", products);
			System.out.println("��Ʒ����"+products.getP_name()+"---�۸�"+
					products.getP_price()+"--������"+products.getP_info()+
					"--������"+products.getP_sale()+"--��棺"+products.getP_stock()+
					"���ۣ�"+products.getReviews().get(0).getR_info()+"�����ˣ�"+
					"�����ˣ�"+products.getReviews().get(0).getUser().getU_name()+
					"����ʱ��"+products.getReviews().get(0).getR_time()+
					"--ͼƬ��"+products.getImages().get(0).getI_path()+
					"ͼƬ������"+products.getImages().size());
		
		return "productdetails";
	}
	/**
	 * ���ݹؼ��ֽ���ģ����ѯ
	 * @return
	 * @time:2017��8��22�� ����10:27:33
	 */
	@RequestMapping(value = "/fuzzy",method = RequestMethod.POST)
	public String getBySelect(String pname){
		List<Product> products = productService.findBySelect(pname);
		System.out.println(pname);
		for(int i = 0;i < products.size();i++ ){
			System.out.println("��Ʒ����"+products.get(i).getP_name()+"---�۸�"+
					products.get(i).getP_price()+"--������"+products.get(i).getP_info()+
					"--������"+products.get(i).getP_sale()+"--ͼƬ��"+products.get(i).getImages().get(0));
		}
		return "index";
	}
	/**
	 * ��ѯ������Ʒ��Ʒ��
	 * @return
	 * @time:2017��8��22�� ����10:40:01
	 */
	@RequestMapping("brand")
	public String getAllBrand(Model model){
		List<Brand> brands = productService.getAllBrand();
		model.addAttribute("brands",brands);
		for(int i = 0;i < brands.size();i++){
			System.out.println("Ʒ������"+brands.get(i).getB_name()+"--Ʒ��ͼƬ��"+
					brands.get(i).getB_logo());
		}
		//
		int total = brands.size();
		int line = total%3==0?total/3:total/3+1;
		model.addAttribute("line", line);
		return "index";
	}
}
