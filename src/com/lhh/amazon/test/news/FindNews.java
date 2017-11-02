package com.lhh.amazon.test.news;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.News;
import com.lhh.amazon.service.INewsService;
import com.lhh.amazon.service.impl.NewsServiceImpl;

/**
 * 
 * 根据ID来查询新闻的信息
 * @author 46512
 *
 */
public class FindNews {
	public static void main(String[] args) {
		INewsService newsService = new NewsServiceImpl();
		News news = new News();
		try {
			news = newsService.findNews(3L);
			System.out.println(news);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
