package com.newer.phone.dao;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Orders;
/**
 * ����dao��
 * @author Kiven
 *
 */
@Repository
public interface OrdersMapper {

	Orders get();
}
