package com.lhh.amazon.test.order;

import java.util.Collections;
import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.service.IOrderService;
import com.lhh.amazon.service.impl.OrderServiceImpl;

/**
 * 通过用户ID来进行查找
 * 
 * @author 46512
 *
 */
public class FindUserOrder {
	public static void main(String[] args) {
		Long userid = 1004L;
		IOrderService ios = new OrderServiceImpl();
		List<Order> list;
		try {
			list = ios.userAllOrder(userid);
			Collections.sort(list);
			for (Order order : list) {
				System.out.println(order);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
