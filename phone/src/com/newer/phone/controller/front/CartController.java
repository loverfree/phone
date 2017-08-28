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
	 * 查看当前用户的购物车信息:当前测试，接入前端需添加参数
	 * @return
	 * @author samluby
	 */
	@RequestMapping("/")
	public String getCartByUser(){
		Integer u_id = 1;//前端传过来的参数用户id u_id
		List<Cart> carts = cartService.getCartByUser(u_id);
		System.out.println(carts.size());
		for (Cart cart : carts) {
			Product p = cart.getProduct();
			System.out.println(p.toString());
		}
		return "index";
	}
	
	/**
	 * 在当前用户对的购物车中添加商品，参数由前台传入，包括用户id，商品id，商品数量
	 * @return
	 * @author samluby
	 */
	@RequestMapping("addCart")
	public String addCartByUser(){
		Integer u_id = 1;//前端传过来的参数，用户id u_id
		Integer p_id = 3;//前端传过来对的参数，商品id p_id
		Integer c_amount = 5;//前端传过来的参数，添加到购物车的商品的数量 c_amount
		int inTrue = cartService.addCartByUser(u_id,p_id,c_amount);
		System.out.println(inTrue);
		return "index";
		
	}
	
	/**
	 * 对当前用户的购物车进行删除商品，参数由前台传入，包括用户id，商品id，商品数量
	 * @return
	 * @author samluby
	 */
	@RequestMapping("removeCart")
	public String removeCartByProduct(){
		Integer u_id = 1;//前端传过来的参数，用户id
		Integer p_id = 3;//前端传过来的参数，商品id
		int isTrue = cartService.removeCartByProduct(p_id,u_id);
		System.out.println(isTrue);
		return "index";
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
	 * @return
	 * @author samluby
	 */
	@RequestMapping("emptyCart")
	public String removeCartAll(Integer u_id){
		u_id = 2;//参数由前端传入
		int isTrue = cartService.removeCartAll(u_id);
		System.out.println(isTrue);
		return "index";
	}
	
	//由顶当单累结算
	//购物车结算
	@RequestMapping("payCart")
	public String payByCart(){
		return "index";
	}

	
	
	
	
	
	
	
}
