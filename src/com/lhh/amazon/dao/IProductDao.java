package com.lhh.amazon.dao;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.Product;

public interface IProductDao {

	// 查询
	public List<Product> select(Connection conn) throws DataAccessException;

	public Product select(Long id, Connection conn) throws DataAccessException;

	// 条件查询
	public List<Product> select(List<String> condition, Connection conn) throws DataAccessException;

	// 分页查询
	public List<Product> select(List<String> condition, int page, Connection conn) throws DataAccessException;

}
