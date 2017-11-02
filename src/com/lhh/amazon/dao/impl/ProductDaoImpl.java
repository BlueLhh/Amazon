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
import com.lhh.amazon.dao.IProductDao;
import com.lhh.amazon.entity.Product;

public class ProductDaoImpl implements IProductDao {

	// 查询全部的信息
	@Override
	public List<Product> select(Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		List<Product> list = new ArrayList<Product>();

		// 查询全部的SQL语句
		String sql = "select * from hwua_product";

		jt.query(sql, new RowCallBackHandler() {

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
					product.setFileName(rs.getString(7));
					list.add(product);
				}
			}
		});
		return list;
	}

	// 根据ID来查询信息
	@Override
	public Product select(Long id, Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		Product product = new Product();

		// 查询SQL语句
		String sql = "select * from hwua_product where hp_id = ?";

		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, id);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					product.setProductID(rs.getLong(1));
					product.setProductName(rs.getNString(2));
					product.setDescription(rs.getNString(3));
					product.setPrice(rs.getDouble(4));
					product.setStock(rs.getInt(5));
					product.getCategoryID().setCategoryID(rs.getLong(6));
					product.setFileName(rs.getString(7));
				}
			}
		});

		return product;
	}
}
