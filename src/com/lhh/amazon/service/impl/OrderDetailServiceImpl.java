package com.lhh.amazon.service.impl;

import java.sql.Connection;

import com.lhh.amazon.common.ConnectionFactory;
import com.lhh.amazon.common.DBUtils;
import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.dao.IOrderDetailDao;
import com.lhh.amazon.dao.impl.OrderDetailDaoImpl;
import com.lhh.amazon.entity.OrderDetail;
import com.lhh.amazon.service.IOrderDetailService;

public class OrderDetailServiceImpl implements IOrderDetailService {

	private IOrderDetailDao dao;

	public OrderDetailServiceImpl() {
		dao = new OrderDetailDaoImpl();
	}

	@Override
	public OrderDetail creatOD(OrderDetail orderDetail) throws ServiceException {
		Connection conn;
		conn = ConnectionFactory.getConnection();
		try {
			orderDetail = dao.insert(orderDetail, conn);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("添加失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return orderDetail;
	}
}
