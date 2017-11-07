package com.lhh.amazon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.JdbcTemplate;
import com.lhh.amazon.common.PreparedStatementSetter;
import com.lhh.amazon.common.RowCallBackHandler;
import com.lhh.amazon.dao.IOrderDetailDao;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.entity.OrderDetail;

public class OrderDetailDaoImpl implements IOrderDetailDao {

	// 新增一条子订单
	@Override
	public OrderDetail insert(OrderDetail orderDetail, Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		String selectSQL = "select SEQ_DETAIL.nextval from dual";
		jt.query(selectSQL, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					orderDetail.setOrderDetailID(rs.getLong(1));
				}
			}
		});

		String insertSQL = "insert into hwua_order_detail values(?,?,?,?,?)";
		jt.update(insertSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, orderDetail.getOrderDetailID());
				pstmt.setLong(2, orderDetail.getOrder().getOrderID());
				pstmt.setLong(3, orderDetail.getProduct().getProductID());
				pstmt.setInt(4, orderDetail.getQuantity());
				pstmt.setDouble(5, orderDetail.getCost());
			}
		});
		return orderDetail;
	}

	// 通过订单的ID进行查询相关的子订单
	@Override
	public List<OrderDetail> select(Long orderID, Connection conn) throws DataAccessException {
		
		// JdbcTemplate jt = new JdbcTemplate(conn);
		// List<Order> list = new ArrayList<Order>();
		// String sql = "select * from hwua_order_detail where ho_id = ?";
		
		return null;
	}

}
