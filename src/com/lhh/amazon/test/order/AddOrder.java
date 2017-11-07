package com.lhh.amazon.test.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.service.IOrderService;
import com.lhh.amazon.service.impl.OrderServiceImpl;

/**
 * 增加订单
 * 
 * @author 46512
 *
 */
public class AddOrder {
	public static void main(String[] args) {
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String getTime = sdfformat.format(time);
		System.out.println(getTime);
		Long id = Long.parseLong(sdf.format(time));
		System.out.println(id);
		Long userid = 1000L;
		String username = "1234";
		String userAddress = "北海";
		Date createTime = null;
		try {
			createTime = sdfformat.parse(sdfformat.format(time));
			System.out.println(createTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double cost = 100.00;
		int status = 1; 
		int type = 1;
		Order order = new Order();
		IOrderService ios = new OrderServiceImpl();
		
		order.setOrderID(id);
		order.getUser().setUserID(userid);
		order.setUsername(username);
		order.setUserAddress(userAddress);
		order.setCreateTime(createTime);
		order.setCost(cost);
		order.setStatus(status);
		order.setType(type);
		
		try {
			ios.creatOrder(order);
			System.out.println("添加成功！");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
