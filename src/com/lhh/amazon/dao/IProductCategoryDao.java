package com.lhh.amazon.dao;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.ProductCategory;

public interface IProductCategoryDao {
	// 显示全部的商品分类
	public List<ProductCategory> select(Connection conn) throws DataAccessException;

	public List<ProductCategory> bestSelect(Connection conn) throws DataAccessException;
}
