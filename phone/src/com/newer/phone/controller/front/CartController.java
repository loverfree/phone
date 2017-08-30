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
	 * 查看当前用户的购物车信息:
	 * @return OK
	 * @author samluby
	 */
	@RequestMapping("/")
	public String getCartByUser(Model model,@SessionAttribute("curuser")User user){
//		Integer u_id = 1;//前端传过来的参数用户id u_id
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
	 * 在当前用户对的购物车中添加商品，参数由前台传入，包括用户id，商品id，商品数量
	 * @return
	 * @author samluby
	 */
	@RequestMapping("addCart")
	public @ResponseBody List<String> addCartByUser(
			                     @SessionAttribute("curuser")User user,
			                     @RequestParam Integer p_id,
			                     @RequestParam Integer c_amount){
//		Integer p_id = 3;//前端传过来对的参数，商品id p_id
//		Integer c_amount = 5;//前端传过来的参数，添加到购物车的商品的数量 c_amount
		List<String> msg = new ArrayList<>();
		int inTrue = cartService.addCartByUser(user.getU_id(),p_id,c_amount);
		System.out.println(inTrue);
		if(inTrue>0){
			msg.add("添加成功");
		}else{
			msg.add("添加失败");
		}
		return msg;
		
	}
	
	/**
	 * 对当前用户的购物车进行删除商品，参数由前台传入，包括用户id，商品id，商品数量
	 * @return OK
	 * @author samluby
	 */
	@RequestMapping("removeCart/{p_id}")
	public String removeCartByProduct(@PathVariable("p_id")Integer p_id,
			                          @SessionAttribute("curuser")User user){
//		Integer u_id = 1;//前端传过来的参数，用户id
//		Integer p_id = 3;//前端传过来的参数，商品id
		int isTrue = cartService.removeCartByProduct(p_id,user.getU_id());
		System.out.println(isTrue);
		return "redirect:/";
	}
	
	/**
	 * 对当前用户的购物车中的商品进行数量上的更新，参数：商品id，用户id，商品数量c_amount 前端传入
	 * @return
	 * @author samluby
	 */
	@RequestMapping("updateCart")
	public String updateCartByProduct(){
		Integer u_id = 1;//前端传过来的参数，用户id
		Integer p_id = 1;//前端传过来的参数，商品id
		Integer c_amount = 10;//前端传过来的参数，修改的商品的数量 c_amount
		int isTrue = cartService.updateCartByProduct(p_id,u_id,c_amount);
		System.out.println(isTrue);
		return "index";
	}
	
	/**
	 * 根据用户id去清空该用户的购物车中所有商品，参数由前端传入
	 * @param u_id  用户id
	 * @return OK
	 * @author samluby
	 */
	@RequestMapping("emptyCart")
	public String removeCartAll(@SessionAttribute("curuser")User user){
//		u_id = 2;//参数由前端传入
		int isTrue = cartService.removeCartAll(user.getU_id());
		System.out.println(isTrue);
		return "redirect:/";
	}
	
	//由顶当单累结算
	//购物车结算
	@RequestMapping("payCart")
	public String payByCart(){
		return "index";
	}

	
	
	
	
	
	
	
}
