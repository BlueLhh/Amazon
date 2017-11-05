package com.lhh.amazon.service.impl;

import java.sql.Connection;

import com.lhh.amazon.common.ConnectionFactory;
import com.lhh.amazon.common.DBUtils;
import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.dao.IOrderDao;
import com.lhh.amazon.dao.impl.OrderDaoImpl;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	private IOrderDao dao;

	public OrderServiceImpl() {
		dao = new OrderDaoImpl();
	}

	@Override
	public Order creatOrder(Order order) throws ServiceException {
		Connection conn;
		conn = ConnectionFactory.getConnection();
		try {
			order = dao.insert(order, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("添加失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return order;
	}
}
