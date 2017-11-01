package com.lhh.amazon.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.dao.INewsDao;
import com.lhh.amazon.entity.News;

public class NewsDaoImpl implements INewsDao {

	// 插入一条新闻
	public News insert(Connection conn, News news) throws DataAccessException {
		return null;
	}

	// 查询新闻
	@Override
	public List<News> select() throws DataAccessException {
		return null;
	}

}
