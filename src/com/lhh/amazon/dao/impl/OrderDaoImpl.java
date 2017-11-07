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
import com.lhh.amazon.dao.IOrderDao;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.entity.OrderDetail;
import com.lhh.amazon.entity.Product;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public Order insert(Order order, Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		/*
		 * String selectSQL = "select SEQ_ORDER.nextval from dual";
		 * jt.query(selectSQL, new RowCallBackHandler() {
		 * 
		 * @Override public void processRow(ResultSet rs) throws SQLException {
		 * if (rs.next()) { order.setOrderID(rs.getLong(1)); } } });
		 */

		// 插入
		String insertSQL = "insert into hwua_order values(?,?,?,?,?,?,?,?)";
		jt.update(insertSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, order.getOrderID());
				pstmt.setLong(2, order.getUser().getUserID());
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

	// 根据ID来查询信息
	@Override
	public Order select(Long id, Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		Order order = new Order();
		// 查询语句
		String sql = "select * from hwua_order where ho_id = ?";
		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, id);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					order.setOrderID(rs.getLong(1));
					order.getUser().setUserID(rs.getLong(2));
					order.setUsername(rs.getString(3));
					order.setUserAddress(rs.getString(4));
					order.setCreateTime(rs.getDate(5));
					order.setCost(rs.getDouble(6));
					order.setStatus(rs.getInt(7));
					order.setType(rs.getInt(8));
					// 根据订单ID来查询子订单的信息
					String childSQL = "select * from hwua_order_detail where ho_id = ?";
					try {
						jt.query(childSQL, new PreparedStatementSetter() {

							@Override
							public void setValues(PreparedStatement pstmt) throws SQLException {
								pstmt.setLong(1, id);
							}
						}, new RowCallBackHandler() {
							@Override
							public void processRow(ResultSet rs) throws SQLException {
								while (rs.next()) {
									OrderDetail od = new OrderDetail();
									od.setOrderDetailID(rs.getLong(1));
									od.getOrder().setOrderID(rs.getLong(2));
									od.getProduct().setProductID(rs.getLong(3));
									od.setQuantity(rs.getInt(4));
									od.setCost(rs.getDouble(5));
									// ******开始******//
									Long pid;
									pid = od.getProduct().getProductID();
									String pidSQL = "select * from hwua_product where hp_id = " + pid;
									try {
										jt.query(pidSQL, new RowCallBackHandler() {

											@Override
											public void processRow(ResultSet rs) throws SQLException {
												while (rs.next()) {
													Product product = new Product();
													product.setProductID(rs.getLong(1));
													product.setProductName(rs.getNString(2));
													product.setDescription(rs.getNString(3));
													product.setPrice(rs.getDouble(4));
													product.setStock(rs.getInt(5));
													product.getCategoryID().setCategoryID(rs.getLong(6));
													product.getChildID().setChildID(rs.getLong(7));
													product.setFileName(rs.getString(8));
													od.getpList().add(product);
												}
											}
										});
									} catch (DataAccessException e) {
										e.printStackTrace();
									}
									// ******结束******//
									order.getList().add(od);
								}
							}
						});
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
				}
			}
		});
		return order;
	}

	// 查询全部的信息
	@Override
	public List<Order> select(Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from hwua_order";
		jt.query(sql, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Order order = new Order();
					order.setOrderID(rs.getLong(1));
					order.getUser().setUserID(rs.getLong(2));
					order.setUsername(rs.getString(3));
					order.setUserAddress(rs.getString(4));
					order.setCreateTime(rs.getDate(5));
					order.setCost(rs.getDouble(6));
					order.setStatus(rs.getInt(7));
					order.setType(rs.getInt(8));
					list.add(order);
				}
			}
		});
		return list;
	}
}
