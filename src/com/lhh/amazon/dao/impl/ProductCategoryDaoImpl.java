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
import com.lhh.amazon.dao.IProductCategoryDao;
import com.lhh.amazon.entity.ProductCategory;

public class ProductCategoryDaoImpl implements IProductCategoryDao {

	@Override
	public List<ProductCategory> select(Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		List<ProductCategory> list = new ArrayList<ProductCategory>();
		// SQL语句
		String sql = "select * from hwua_product_category";

		jt.query(sql, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					ProductCategory category = new ProductCategory();
					category.setCategoryID(rs.getLong(1));
					category.setCategoryName(rs.getString(2));
					category.setParentCategoryID(rs.getLong(3));
					list.add(category);
				}
			}
		});
		return list;
	}

	// 重量查询
	@Override
	public List<ProductCategory> bestSelect(Connection conn) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		List<ProductCategory> parentList = new ArrayList<ProductCategory>();
		// SQL语句
		String sql = "select * from hwua_product_category where hpc_id = hpc_parent_id";
		jt.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					ProductCategory category = new ProductCategory();
					category.setCategoryID(rs.getLong(1));
					category.setCategoryName(rs.getString(2));
					category.setParentCategoryID(rs.getLong(3));
					// 子项SQL语句
					String childSQL = "select * from hwua_product_category where hpc_id <> hpc_parent_id and hpc_parent_id = ?";
					try {
						jt.query(childSQL, new PreparedStatementSetter() {

							@Override
							public void setValues(PreparedStatement pstmt) throws SQLException {
								pstmt.setLong(1, category.getCategoryID());
							}
						}, new RowCallBackHandler() {

							@Override
							public void processRow(ResultSet rs) throws SQLException {
								while (rs.next()) {
									ProductCategory chlidCategory = new ProductCategory();
									chlidCategory.setCategoryID(rs.getLong(1));
									chlidCategory.setCategoryName(rs.getString(2));
									chlidCategory.setParentCategoryID(rs.getLong(3));
									category.getList().add(chlidCategory);
								}
							}
						});
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
					parentList.add(category);
				}
			}
		});

		return parentList;
	}
}
