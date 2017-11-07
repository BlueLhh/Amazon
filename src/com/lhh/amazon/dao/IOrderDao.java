package com.lhh.amazon.dao;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.Order;

public interface IOrderDao {
	// 生成一条订单信息
	public Order insert(Order order, Connection conn) throws DataAccessException;

	// 显示一条订单 根据ID来查询
	public Order select(Long id, Connection conn) throws DataAccessException;

	// 查询全部的订单
	public List<Order> select(Connection conn) throws DataAccessException;
}
