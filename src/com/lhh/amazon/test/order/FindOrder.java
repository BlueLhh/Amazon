package com.lhh.amazon.test.order;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.service.IOrderService;
import com.lhh.amazon.service.impl.OrderServiceImpl;

/**
 * 根据ID查找订单信息
 * @author 46512
 *
 */
public class FindOrder {
	public static void main(String[] args) {
		IOrderService ios = new OrderServiceImpl();
		Long id = 20171106234916L;
		Order order;
		try {
			order = ios.findOrder(id);
			System.out.println(order);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
