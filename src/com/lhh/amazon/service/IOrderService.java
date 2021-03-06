package com.lhh.amazon.service;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Order;

public interface IOrderService {
	// 生成一条订单
	public Order creatOrder(Order order) throws ServiceException;

	// 查询订单
	public Order findOrder(Long id) throws ServiceException;

	// 查询订单 根据用户订单来查询
	public List<Order> userAllOrder(Long userid) throws ServiceException;

	// 更新订单状态
	public void updateOrder(Long orderid) throws ServiceException;

	// 删除订单
	public void delOrder(Long orderid) throws ServiceException;

	// 模拟删除
	public void updateDel(Long orderid) throws ServiceException;

}
