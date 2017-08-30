package com.newer.phone.service.front.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.CartMapper;
import com.newer.phone.dao.ProductMapper;
import com.newer.phone.pojo.Cart;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.front.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * �鿴���ﳵ������ǰ�˴��Ĳ����û�id u_id����session�л�ã�ȥ��ѯCART��u_id=���������м�¼��
	 * ����Cart��Lise���ϡ�
	 */
	@Override
	public List<Cart> getCartByUser(Integer u_id) {
		List<Cart> carts = cartMapper.getCartByUser(u_id);
		System.out.println("cartService:"+carts.size());
		return carts;
	}
	
	/**
	 * �����Ʒ�����ﳵ������ǰ�˴��Ĳ����û�id����Ʒidȥcart���в�ѯ�Ƿ��д�����¼�����У�����ʾ�û�����Ӹ���Ʒ
	 * û�У���u_id,p_id,c_amountȥinset��cart��
	 */
	@Override
	public int addCartByUser(Integer u_id, Integer p_id, Integer c_amount) {
		System.out.println("��ʼ��ѯ");
		Cart cart = cartMapper.getCartByUserAndProduct(u_id, p_id);
		System.out.println("��ѯ����");
		if (cart==null) {
			return cartMapper.addCartByUser(u_id, p_id, c_amount);
		}
		return 0;
	}
	
	/**
	 * ɾ���û��Ĺ��ﳵ�е���Ʒ�������û�id����Ʒidȥɾ����where p_id=? and u_id=?
	 */
	@Override
	public int removeCartByProduct(Integer p_id, Integer u_id) {
		return cartMapper.removeCartByProduct(p_id,u_id);
	}

	/**
	 * �ȸ�����ƷidȥPRODUCT���в�ѯ��Ʒ�Ƿ�����ô����
	 * ����ô����ٸ����û�id����Ʒidȥ��������
	 */
	@Override
	public int updateCartByProduct(Integer p_id, Integer u_id, Integer c_amount) {
		Product product = productMapper.findById(p_id);
		if(c_amount<=product.getP_stock()){
			return cartMapper.updateCartByProduct(p_id, u_id, c_amount);
		}
		return 0;
	}

	/**
	 * �����û�id��չ��ﳵ
	 */
	@Override
	public int removeCartAll(Integer u_id) {
		return cartMapper.removeCartAll(u_id);
	}

}