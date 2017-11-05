package com.lhh.amazon.dao;

import java.sql.Connection;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.Order;

public interface IOrderDao {
	// 生成一条订单信息
	public Order insert(Order order,Connection conn)throws DataAccessException;
	// 显示一条订单
}
