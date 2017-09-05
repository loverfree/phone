package com.newer.phone.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Orders;
import com.newer.phone.service.back.OrderServiceBack;
import com.newer.phone.service.front.OrdersService;

@Controller
@RequestMapping("/order")
public class BackOrdersController {
	
	@Autowired
	OrderServiceBack orderServiceBack;
	@Autowired
	OrdersService ordersService;
	
	@RequestMapping("/list")
	public String getOrder(Integer pageNo,Integer pageSize,Model model){
		PageInfo<Orders> page = orderServiceBack.findAllOrders(pageNo, pageSize);
		model.addAttribute("page", page);
		return "backOrder";
		
	}
	@RequestMapping("/listone")
	public String getOrderOne(Integer pageNo,Integer pageSize,Model model){
		PageInfo<Orders> page = orderServiceBack.findOrdersOne(pageNo, pageSize);
		model.addAttribute("page", page);
		return "backOrderOne";
		
	}
	@RequestMapping("/listtwo")
	public String getOrderTwo(Integer pageNo,Integer pageSize,Model model){
		PageInfo<Orders> page = orderServiceBack.findOrdersTwo(pageNo, pageSize);
		model.addAttribute("page", page);
		return "backOrderTwo";
		
	}
	@RequestMapping("/listthree")
	public String getOrderThree(Integer pageNo,Integer pageSize,Model model){
		PageInfo<Orders> page = orderServiceBack.findOrdersThree(pageNo, pageSize);
		model.addAttribute("page", page);
		return "backOrderThree";
		
	}
	@RequestMapping("/listfour")
	public String getOrderFour(Integer pageNo,Integer pageSize,Model model){
		PageInfo<Orders> page = orderServiceBack.findOrdersFour(pageNo, pageSize);
		model.addAttribute("page", page);
		return "backOrderFour";
		
	}
	
	@RequestMapping("/confirmOk/{o_id}")
	public String confirmOk(@PathVariable("o_id")Integer o_id){
		//更新通知
		ordersService.setInform(2,o_id);
		//更新订单状态
		ordersService.updateStatus(2, o_id);
		return "redirect:../listtwo";
	}
}
