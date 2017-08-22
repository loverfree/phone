package com.newer.phone.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.phone.pojo.Brand;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.front.ProductService;

@Controller
@RequestMapping("product")
public class ProdcutController {
	@Autowired
	private ProductService productService;
	
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
	
	/**
	 * ������Ʒid��ѯ��Ʒ��ϸ����
	 * @return
	 * @time:2017��8��22�� ����10:25:41
	 */
	@RequestMapping("/aaa")
	public String getById(){
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
	/**
	 * ���ݹؼ��ֽ���ģ����ѯ
	 * @return
	 * @time:2017��8��22�� ����10:27:33
	 */
	@RequestMapping("select")
	public String getBySelect(){
		List<Product> products = productService.findBySelect("6");
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
	public String getAllBrand(){
		List<Brand> brands = productService.getAllBrand();
		for(int i = 0;i < brands.size();i++){
			System.out.println("Ʒ������"+brands.get(i).getB_name()+"--Ʒ��ͼƬ��"+
					brands.get(i).getB_logo());
		}
		return "index";
	}
}
