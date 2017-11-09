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

	// 根据用户的ID来查找该用户的订单
	public List<Order> query(Long userid, Connection conn) throws DataAccessException;

	// 根据订单的id对订单进行状态的修改
	public void update(Long orderid, Connection conn) throws DataAccessException;

	// 通过订单的ID进行删除订单 级联删除
	public void delete(Long orderid, Connection conn) throws DataAccessException;
}
