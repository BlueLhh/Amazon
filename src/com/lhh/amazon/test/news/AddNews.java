package com.lhh.amazon.test.news;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.News;
import com.lhh.amazon.service.INewsService;
import com.lhh.amazon.service.impl.NewsServiceImpl;

/**
 * 
 * 测试新建一条新闻
 * 
 * @author 46512
 *
 */
public class AddNews {
	public static void main(String[] args) {
		String title;// 通知主题
		String content;// 通知内容
		Date createTime = null;// 创建通知的时间

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("主题：");
		title = sc.next();
		System.out.println("内容：");
		content = sc.next();
		System.out.println("时间：");
		String str = sc.next();
		try {
			createTime = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		INewsService newsService = new NewsServiceImpl();
		News news = new News();
		
		news.setTitle(title);
		news.setContent(content);
		news.setCreateTime(createTime);
		
		try {
			newsService.createNews(news);
			System.out.println("创建成功！");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
