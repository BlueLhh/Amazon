package com.lhh.amazon.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.News;
import com.lhh.amazon.service.INewsService;
import com.lhh.amazon.service.impl.NewsServiceImpl;

@WebServlet("/readNews")
public class ReadNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadNewsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面的ID
		String newsID = request.getParameter("id");
		Long id = Long.parseLong(newsID);
		INewsService newsService = new NewsServiceImpl();
		News news = new News();
		try {
			news = newsService.findNews(id);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		request.setAttribute("news", news);
		// 分发器
		RequestDispatcher rd = request.getRequestDispatcher("news_view.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
