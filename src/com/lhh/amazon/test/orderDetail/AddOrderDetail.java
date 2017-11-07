package com.lhh.amazon.test.orderDetail;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.OrderDetail;
import com.lhh.amazon.service.IOrderDetailService;
import com.lhh.amazon.service.impl.OrderDetailServiceImpl;

/**
 * 测试添加子订单
 * 
 * @author 46512
 *
 */
public class AddOrderDetail {
	public static void main(String[] args) {
		IOrderDetailService ids = new OrderDetailServiceImpl();
		OrderDetail orderDetail = new OrderDetail();
		// 获取当前的时间设置为订单的ID
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Long orderid = Long.parseLong(sdf.format(time));
		System.out.println(orderid);
		Long pid = 2L;
		int quantity = 10;
		double cost = 20.0;
		orderid = 20171106234747L;

		orderDetail.getOrder().setOrderID(orderid);
		orderDetail.getProduct().setProductID(pid);
		orderDetail.setQuantity(quantity);
		orderDetail.setCost(cost);

		try {
			ids.creatOD(orderDetail);
			System.out.println("添加成功！");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}
