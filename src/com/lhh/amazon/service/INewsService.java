package com.lhh.amazon.service;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.News;

public interface INewsService {
	// 创建一条新闻
	public News createNews(News news) throws ServiceException;

	// 通过ID来查找一条信息
	public News findNews(Long id) throws ServiceException;

	// 显示全部的新闻
	public List<News> showNews(News news) throws ServiceException;

	public List<News> showNews() throws ServiceException;
}
