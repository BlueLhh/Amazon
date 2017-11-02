package com.lhh.amazon.service.impl;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.ConnectionFactory;
import com.lhh.amazon.common.DBUtils;
import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.dao.INewsDao;
import com.lhh.amazon.dao.impl.NewsDaoImpl;
import com.lhh.amazon.entity.News;
import com.lhh.amazon.service.INewsService;

public class NewsServiceImpl implements INewsService {

	private INewsDao dao;

	public NewsServiceImpl() {
		dao = new NewsDaoImpl();
	}

	// 创建一条新闻
	@Override
	public News createNews(News news) throws ServiceException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		try {
			news = dao.insert(conn, news);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("创建新闻失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return news;
	}

	// 显示全部的新闻
	@Override
	public List<News> showNews(News news) throws ServiceException {

		Connection conn = null;
		List<News> list = null;
		conn = ConnectionFactory.getConnection();

		try {
			list = dao.select(conn);
		} catch (DataAccessException e) {
			throw new ServiceException("显示失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}

		return list;
	}

	@Override
	public List<News> showNews() throws ServiceException {
		Connection conn = null;
		List<News> list = null;
		conn = ConnectionFactory.getConnection();

		try {
			list = dao.select(conn);
		} catch (DataAccessException e) {
			throw new ServiceException("显示失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}

		return list;
	}

	@Override
	public News findNews(Long id) throws ServiceException {
		Connection conn;
		News news = new News();
		conn = ConnectionFactory.getConnection();
		try {
			news = dao.select(id, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("查找失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return news;
	}
}
