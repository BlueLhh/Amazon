package com.lhh.amazon.service;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.OrderDetail;

public interface IOrderDetailService {
	// 新增一条子订单
	public OrderDetail creatOD(OrderDetail orderDetail) throws ServiceException;
}
