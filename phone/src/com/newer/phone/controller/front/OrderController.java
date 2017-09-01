package com.newer.phone.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.newer.phone.pojo.Orders;
import com.newer.phone.pojo.User;
import com.newer.phone.service.front.OrdersService;

@Controller
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private OrdersService ordersService;
	
	/**
	 * ���ݵ�ǰ�û���id���鿴����û������ж�����4��״̬�Ķ�����
	 * @return
	 * @author samluby
	 */
	@RequestMapping("/")
	public String getOrderByUser(@SessionAttribute("curuser") User user,Model model){
//		Integer u_id = 1;//ǰ�˴�����û�id
		List<Orders> orders = ordersService.getOrderByUser(user.getU_id());
		model.addAttribute("orders",orders);
		return "orderList";
	}
	
	/**
	 * ���ݵ�ǰ�û���id��ǰ�˴������Ķ���id��ɾ���ö���
	 * @param u_id �û�id
	 * @param o_id ����id
	 * @return
	 * @author samluby
	 */
	@RequestMapping("removeOrders/{o_id}")
	public String removeOrderById(@PathVariable("o_id")Integer o_id,
			                      @SessionAttribute("curuser")User user){
//		Integer u_id = 1;
//		Integer o_id = 2;
		int isTrue = ordersService.removeOrderById(user.getU_id(), o_id);
		System.out.println(isTrue);
		return "redirect:../";
	}

	/**
	 * ����
	 * @return
	 * @author samluby
	 */
	@RequestMapping("pay")
	public String pay(Orders order,@SessionAttribute("curuser")User user){
		order.setUser(user);
		boolean flag = ordersService.addOrder(order);
		if(flag==true){
			return "paySucceed";
		}
		return "payLose";
	}
}
