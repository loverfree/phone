package com.newer.phone.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Orders;
import com.newer.phone.service.back.OrderServiceBack;

@Controller
@RequestMapping("/order")
public class BackOrdersController {
	
	@Autowired
	OrderServiceBack orderServiceBack;
	
	@RequestMapping("/list")
	public String getOrder(Integer pageNo,Integer pageSize,Model model){
		PageInfo<Orders> page = orderServiceBack.findAllOrders(pageNo, pageSize);
		model.addAttribute("page", page);
		return "backOrder";
		
	}
}
