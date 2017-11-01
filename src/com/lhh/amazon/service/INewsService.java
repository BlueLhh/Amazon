package com.lhh.amazon.service;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.News;

public interface INewsService {
	// 创建一条新闻
	public News createNews(News news) throws ServiceException;

	// 显示全部的新闻
	public List<News> showNews() throws ServiceException;
}
