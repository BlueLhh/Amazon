package com.lhh.amazon.test.news;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.News;
import com.lhh.amazon.service.INewsService;
import com.lhh.amazon.service.impl.NewsServiceImpl;

/**
 * 
 * 显示全部的新闻
 * 
 * @author 46512
 *
 */
public class ShowNews {
	public static void main(String[] args) {
		INewsService newsService = new NewsServiceImpl();
		// News news = new News();
		List<News> list = null;
		try {
			// list = newsService.showNews(news);
			list = newsService.showNews();
			if(list.size() > -1){
				for (News news2 : list) {
					System.out.println(news2);
				}
			}else{
				System.out.println("没有找到相关的信息");
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}
