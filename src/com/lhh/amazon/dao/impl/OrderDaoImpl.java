package com.lhh.amazon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.JdbcTemplate;
import com.lhh.amazon.common.PreparedStatementSetter;
import com.lhh.amazon.common.RowCallBackHandler;
import com.lhh.amazon.dao.IOrderDao;
import com.lhh.amazon.entity.Order;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public Order insert(Order order, Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		String selectSQL = "select SEQ_ORDER.nextval from dual";
		jt.query(selectSQL, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					order.setOrderID(rs.getLong(1));
				}
			}
		});

		// 插入
		String insertSQL = "insert into hwua_order values(?,?,?,?,?,?,?,?)";
		jt.update(insertSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, order.getOrderID());
				pstmt.setLong(2, order.getUserID().getUserID());
				pstmt.setString(3, order.getUsername());
				pstmt.setString(4, order.getUserAddress());
				pstmt.setDate(5, new java.sql.Date(order.getCreateTime().getTime()));
				pstmt.setDouble(6, order.getCost());
				pstmt.setInt(7, order.getStatus());
				pstmt.setInt(8, order.getType());
			}
		});
		return order;
	}

}
