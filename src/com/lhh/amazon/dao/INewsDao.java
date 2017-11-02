package com.lhh.amazon.dao;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.News;

public interface INewsDao {
	// 插入一条新闻
	public News insert(Connection conn, News news) throws DataAccessException;

	// 查找新闻
	public News select(Long id, Connection conn) throws DataAccessException;

	// 显示新闻
	public List<News> select(Connection conn) throws DataAccessException;

	// public List<News> select() throws DataAccessException;

}
