package com.lhh.amazon.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
			e.printStackTrace();
			throw new ServiceException("添加失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return order;
	}

	@Override
	public Order findOrder(Long id) throws ServiceException {

		Connection conn;
		Order order = new Order();
		conn = ConnectionFactory.getConnection();
		try {
			order = dao.select(id, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("查找失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return order;
	}

	@Override
	public List<Order> userAllOrder(Long userid) throws ServiceException {

		Connection conn;
		List<Order> list = new ArrayList<Order>();
		conn = ConnectionFactory.getConnection();
		try {
			list = dao.query(userid, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("查找失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return list;
	}

	// 通过订单ID进行订单状态的修改
	@Override
	public void updateOrder(Long orderid) throws ServiceException {
		Connection conn;
		conn = ConnectionFactory.getConnection();
		try {
			dao.update(orderid, conn);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("更新失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
	}

	@Override
	public void delOrder(Long orderid) throws ServiceException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		try {
			dao.delete(orderid, conn);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("删除失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
	}

	@Override
	public void updateDel(Long orderid) throws ServiceException {
		Connection conn;
		conn = ConnectionFactory.getConnection();
		try {
			dao.updateDel(orderid, conn);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("删除失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
	}
}
