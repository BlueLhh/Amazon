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
import com.lhh.amazon.dao.ICartDao;
import com.lhh.amazon.entity.Cart;

public class CartDaoImpl implements ICartDao {

	// 创建一个购物车
	@Override
	public Cart insert(Connection conn, Cart cart) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		String selectSQL = "select SEQ_HWUA_CART.nextval from dual";

		jt.query(selectSQL, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					cart.setCartID(rs.getLong(1));
				}
			}
		});

		// 插入sql语句
		String insertSQL = "insert into hwua_cart values(?,?,?,?)";
		jt.update(insertSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, cart.getCartID());
				pstmt.setLong(2, cart.getProductID());
				pstmt.setInt(3, cart.getQuantity());
				pstmt.setLong(4, cart.getUserID());
			}
		});
		return cart;
	}

	// 删除 结算之后删除购物车
	@Override
	public void delete(Long id, Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		String sql = "delete from hwua_cart where id = ?";
		jt.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, id);
			}
		});
	}

	// 根据用户ID来进行删除
	@Override
	public void deleteAll(Long userid, Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		String sql = "delete from hwua_cart where userid = ?";
		jt.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, userid);
			}
		});
	}

	// 更新信息 在商品也购买的时候使用的
	@Override
	public void update(Long pID, Long userID, int quantity, Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		// 更新的SQL语句
		String sql = "update hwua_cart set quantity = ? where pid = ? and userid = ?";
		jt.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, quantity);
				pstmt.setLong(2, pID);
				pstmt.setLong(3, userID);
			}
		});
	}

	// 根据ID来更新 在购物车中添加的时候使用的
	@Override
	public void update(Long id, int quantity, Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		// 更新的SQL语句
		String sql = "update hwua_cart set quantity = ? where id = ?";
		jt.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, quantity);
				pstmt.setLong(2, id);
			}
		});
	}

	// 显示当前用户的购物车里的信息
	@Override
	public List<Cart> select(Long userid, Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		List<Cart> list = new ArrayList<Cart>();
		String sql = "select * from hwua_cart where userid = ?";

		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, userid);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Cart cart = new Cart();
					cart.setCartID(rs.getLong(1));
					cart.setProductID(rs.getLong(2));
					cart.setQuantity(rs.getInt(3));
					cart.setUserID(rs.getLong(4));
					list.add(cart);
				}
			}
		});
		return list;
	}

	// 通过用户id和商品的id来进行查询该数据是否存在
	@Override
	public Cart select(Long pid, Long userid, Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		Cart cart = new Cart();
		String sql = "select * from hwua_cart where pid = ? and userid = ?";
		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, pid);
				pstmt.setLong(2, userid);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					cart.setCartID(rs.getLong(1));
					cart.setProductID(rs.getLong(2));
					cart.setQuantity(rs.getInt(3));
					cart.setUserID(rs.getLong(4));
				}
			}
		});
		return cart;
	}
}
