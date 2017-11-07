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
import com.lhh.amazon.entity.HotSale;
import com.lhh.amazon.entity.OrderDetail;
import com.lhh.amazon.entity.Product;

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

	// 通过订单的商品ID查询
	@Override
	public List<OrderDetail> select(Long orderID, Connection conn) throws DataAccessException {

		return null;
	}

	// 查询热销榜
	@Override
	public List<HotSale> select(Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		List<HotSale> list = new ArrayList<HotSale>();
		String sql = "SELECT HP_ID,SUM(HOD_QUANTITY) AS QUANTITY FROM HWUA_ORDER_DETAIL GROUP BY HP_ID ORDER BY SUM(HOD_QUANTITY) DESC";
		jt.query(sql, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					HotSale hotSale = new HotSale();
					hotSale.getProduct().setProductID(rs.getLong(1));
					hotSale.setQuantity(rs.getInt(2));
					// 设置用来查询的id
					Long pid;
					pid = hotSale.getProduct().getProductID();
					String pSQL = "select * from hwua_product where hp_id = " + pid;
					try {
						jt.query(pSQL, new RowCallBackHandler() {

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
									hotSale.getList().add(product);
								}
							}
						});
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
					list.add(hotSale);
				}
			}
		});
		return list;
	}
}
