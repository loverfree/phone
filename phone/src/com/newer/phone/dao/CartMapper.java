package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Cart;

/**
 * ���ﳵ��CART�־ò�
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017��8��20�� ����11:28:20
 */
@Repository
public interface CartMapper {

	/**
	 * �鿴��ǰ�û��Ĺ��ﳵ
	 * @param u_id ��ǰ�û���id
	 * @return ���ﳵ�е�������Ʒ����
	 */
	List<Cart> getCartByUser(@Param("u_id")Integer u_id);
	
	/**
	 * �����Ʒ����ǰ�û��Ĺ��ﳵ
	 * @param u_id ��ǰ�û�id
	 * @param p_id ѡ����Ʒ��id
	 * @param c_amount ѡ����Ʒ�Ե�����
	 * @return
	 * @author samluby
	 */
	int addCartByUser(@Param("u_id")Integer u_id,
			          @Param("p_id")Integer p_id,
			          @Param("c_amount")Integer c_amount);
	
	/**
	 * �����û�id����Ʒid�жϸù��ﳵ���Ƿ��Ѵ��ڸ���Ʒ
	 * @param u_id
	 * @param p_id
	 * @return
	 * @author samluby
	 */
	Cart getCartByUserAndProduct(@Param("u_id")Integer u_id,
			                     @Param("p_id")Integer p_id);

	/**
	 * ������Ʒidȥɾ�����ﳵ�е���Ʒ
	 * @param p_id ��Ʒid
	 * @param u_id �û�id
	 * @return
	 * @author samluby
	 */
	int removeCartByProduct(@Param("p_id")Integer p_id,
			                @Param("u_id")Integer u_id);
	
	int updateCartByProduct(@Param("p_id")Integer p_id,
			                @Param("u_id")Integer u_id,
			                @Param("c_amount")Integer c_amount);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

