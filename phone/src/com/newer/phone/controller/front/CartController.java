package com.newer.phone.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.phone.pojo.Cart;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.front.CartService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	/**
	 * �鿴��ǰ�û��Ĺ��ﳵ��Ϣ:��ǰ���ԣ�����ǰ������Ӳ���
	 * @return
	 * @author samluby
	 */
	@RequestMapping("/")
	public String getCartByUser(){
		Integer u_id = 1;//ǰ�˴������Ĳ����û�id u_id
		List<Cart> carts = cartService.getCartByUser(u_id);
		System.out.println(carts.size());
		for (Cart cart : carts) {
			Product p = cart.getProduct();
			System.out.println(p.toString());
		}
		return "index";
	}
	
	/**
	 * �ڵ�ǰ�û��ԵĹ��ﳵ�������Ʒ��������ǰ̨���룬�����û�id����Ʒid����Ʒ����
	 * @return
	 * @author samluby
	 */
	@RequestMapping("addCart")
	public String addCartByUser(){
		Integer u_id = 1;//ǰ�˴������Ĳ������û�id u_id
		Integer p_id = 3;//ǰ�˴������ԵĲ�������Ʒid p_id
		Integer c_amount = 5;//ǰ�˴������Ĳ�������ӵ����ﳵ����Ʒ������ c_amount
		int inTrue = cartService.addCartByUser(u_id,p_id,c_amount);
		System.out.println(inTrue);
		return "index";
		
	}
	
	/**
	 * �Ե�ǰ�û��Ĺ��ﳵ����ɾ����Ʒ��������ǰ̨���룬�����û�id����Ʒid����Ʒ����
	 * @return
	 * @author samluby
	 */
	@RequestMapping("removeCart")
	public String removeCartByProduct(){
		Integer u_id = 1;//ǰ�˴������Ĳ������û�id
		Integer p_id = 3;//ǰ�˴������Ĳ�������Ʒid
		int isTrue = cartService.removeCartByProduct(p_id,u_id);
		System.out.println(isTrue);
		return "index";
	}
	
	/**
	 * �Ե�ǰ�û��Ĺ��ﳵ�е���Ʒ���������ϵĸ��£���������Ʒid���û�id����Ʒ����c_amount ǰ�˴���
	 * @return
	 * @author samluby
	 */
	@RequestMapping("updateCart")
	public String updateCartByProduct(){
		Integer u_id = 1;//ǰ�˴������Ĳ������û�id
		Integer p_id = 1;//ǰ�˴������Ĳ�������Ʒid
		Integer c_amount = 10;//ǰ�˴������Ĳ������޸ĵ���Ʒ������ c_amount
		int isTrue = cartService.updateCartByProduct(p_id,u_id,c_amount);
		System.out.println(isTrue);
		return "index";
	}
	
	/**
	 * �����û�idȥ��ո��û��Ĺ��ﳵ��������Ʒ��������ǰ�˴���
	 * @param u_id  �û�id
	 * @return
	 * @author samluby
	 */
	@RequestMapping("emptyCart")
	public String removeCartAll(Integer u_id){
		u_id = 2;//������ǰ�˴���
		int isTrue = cartService.removeCartAll(u_id);
		System.out.println(isTrue);
		return "index";
	}
	
	//�ɶ������۽���
	//���ﳵ����
	@RequestMapping("payCart")
	public String payByCart(){
		return "index";
	}

	
	
	
	
	
	
	
}
