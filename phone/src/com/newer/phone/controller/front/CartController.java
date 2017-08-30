package com.newer.phone.controller.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.newer.phone.pojo.Cart;
import com.newer.phone.pojo.Product;
import com.newer.phone.pojo.User;
import com.newer.phone.service.front.CartService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	/**
	 * �鿴��ǰ�û��Ĺ��ﳵ��Ϣ:
	 * @return OK
	 * @author samluby
	 */
	@RequestMapping("/")
	public String getCartByUser(Model model,@SessionAttribute("curuser")User user){
//		Integer u_id = 1;//ǰ�˴������Ĳ����û�id u_id
		List<Cart> carts = cartService.getCartByUser(user.getU_id());
		System.out.println(carts.size());
//		for (Cart cart : carts) {
//			Product p = cart.getProduct();
//			System.out.println(p.toString());
//		}
		model.addAttribute("carts",carts);
		return "cart";
	}
	
	/**
	 * �ڵ�ǰ�û��ԵĹ��ﳵ�������Ʒ��������ǰ̨���룬�����û�id����Ʒid����Ʒ����
	 * @return
	 * @author samluby
	 */
	@RequestMapping("addCart")
	public @ResponseBody List<String> addCartByUser(
			                     @SessionAttribute("curuser")User user,
			                     @RequestParam Integer p_id,
			                     @RequestParam Integer c_amount){
//		Integer p_id = 3;//ǰ�˴������ԵĲ�������Ʒid p_id
//		Integer c_amount = 5;//ǰ�˴������Ĳ�������ӵ����ﳵ����Ʒ������ c_amount
		List<String> msg = new ArrayList<>();
		int inTrue = cartService.addCartByUser(user.getU_id(),p_id,c_amount);
		System.out.println(inTrue);
		if(inTrue>0){
			msg.add("��ӳɹ�");
		}else{
			msg.add("���ʧ��");
		}
		return msg;
		
	}
	
	/**
	 * �Ե�ǰ�û��Ĺ��ﳵ����ɾ����Ʒ��������ǰ̨���룬�����û�id����Ʒid����Ʒ����
	 * @return OK
	 * @author samluby
	 */
	@RequestMapping("removeCart/{p_id}")
	public String removeCartByProduct(@PathVariable("p_id")Integer p_id,
			                          @SessionAttribute("curuser")User user){
//		Integer u_id = 1;//ǰ�˴������Ĳ������û�id
//		Integer p_id = 3;//ǰ�˴������Ĳ�������Ʒid
		int isTrue = cartService.removeCartByProduct(p_id,user.getU_id());
		System.out.println(isTrue);
		return "redirect:/";
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
	 * @return OK
	 * @author samluby
	 */
	@RequestMapping("emptyCart")
	public String removeCartAll(@SessionAttribute("curuser")User user){
//		u_id = 2;//������ǰ�˴���
		int isTrue = cartService.removeCartAll(user.getU_id());
		System.out.println(isTrue);
		return "redirect:/";
	}
	
	//�ɶ������۽���
	//���ﳵ����
	@RequestMapping("payCart")
	public String payByCart(){
		return "index";
	}

	
	
	
	
	
	
	
}
