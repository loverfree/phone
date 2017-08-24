package com.newer.phone.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.phone.pojo.Orders;
import com.newer.phone.service.front.OrdersService;

@Controller
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private OrdersService ordersService;
	
	/**
	 * 根据当前用户的id来查看这个用户的所有订单，4中状态的都包括
	 * @return
	 * @author samluby
	 */
	@RequestMapping("/")
	public String getOrderByUser(){
		Integer u_id = 1;//前端传入的用户id
		List<Orders> orders = ordersService.getOrderByUser(u_id);
		if(orders.size()!=0){
			System.out.println("OK");
			System.out.println(orders.get(0).getA_city()+"   "+
					orders.get(0).getO_id()+"   "+
					orders.get(0).getO_time()+"  "
					+orders.get(0).getO_total()+"  "+
					orders.get(0).getUser().getU_id()+"    "+
					orders.get(0).getUser().getU_name()+"   "+
					orders.get(0).getP_os().get(0).getC_amount()+"    "+
					orders.get(0).getP_os().get(0).getProduct().getP_name());
		}else {
			System.out.println("lose");
		}
		return "index";
	}
	
	/**
	 * 根据当前用户的id和前端传过来的订单id来删除该订单
	 * @param u_id 用户id
	 * @param o_id 订单id
	 * @return
	 * @author samluby
	 */
	@RequestMapping("removeOrders")
	public String removeOrderById(){
		Integer u_id = 1;
		Integer o_id = 2;
		int isTrue = ordersService.removeOrderById(u_id, o_id);
		System.out.println(isTrue);
		return "index";
	}

}
