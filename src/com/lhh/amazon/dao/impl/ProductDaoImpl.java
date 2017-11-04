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
					product.getChildID().setChildID(rs.getLong(7));
					product.setFileName(rs.getString(8));
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
					product.getChildID().setChildID(rs.getLong(7));
					product.setFileName(rs.getString(8));
				}
			}
		});

		return product;
	}

	// 条件查询
	@Override
	public List<Product> select(List<String> condition, Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		List<Product> list = new ArrayList<Product>();
		String sql = "select * " + "from hwua_product " + "where 1 = 1";
		if (condition.size() > 0) {
			for (String conditions : condition) {
				sql += " and ";
				sql += conditions;
			}
		}
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
					product.getChildID().setChildID(rs.getLong(7));
					product.setFileName(rs.getString(8));
					list.add(product);
				}
			}
		});
		return list;
	}

	// 分页查询
	@Override
	public List<Product> select(List<String> condition, int page, Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		List<Product> list = new ArrayList<Product>();
		// 设置每一页有多少商品
		int productNum = 12;
		// 在数据库中分页查询的开始和结束
		// 当page为1的时候
		int start = (page - 1) * productNum + 1;
		int end = page * productNum;
		// sql 子句筛选商品 rn 为行数的别名
		String childSQL = "select hp_id,hp_name,hp_description,hp_price,hp_stock,hpc_id,hpc_child_id,hp_file_name,rownum rn from hwua_product where 1 = 1";
		if (condition.size() != 0) {
			for (String cond : condition) {
				childSQL += " and ";
				childSQL += cond;
			}
		}
		// 查询从第n条到第n+11条的记录
		String sql = "select * from (" + childSQL + ") p1 where rn between ? and ?";
		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
		}, new RowCallBackHandler() {

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
					list.add(product);
				}
			}
		});
		return list;
	}
}
