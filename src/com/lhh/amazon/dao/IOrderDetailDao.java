package com.lhh.amazon.dao;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.HotSale;
import com.lhh.amazon.entity.OrderDetail;

public interface IOrderDetailDao {
	// 新增一条子订单
	public OrderDetail insert(OrderDetail orderDetail, Connection conn) throws DataAccessException;

	// 查询子订单 通过订单ID进行查询
	public List<OrderDetail> select(Long orderID, Connection conn) throws DataAccessException;

	// 查询热销榜
	public List<HotSale> select(Connection conn) throws DataAccessException;
}
