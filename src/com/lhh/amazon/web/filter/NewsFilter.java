package com.lhh.amazon.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.News;
import com.lhh.amazon.service.INewsService;
import com.lhh.amazon.service.impl.NewsServiceImpl;

@WebFilter(filterName = "NewsFilter", urlPatterns = { "/index.jsp", "/readNews" })
public class NewsFilter implements Filter {

	// 销毁
	@Override
	public void destroy() {

	}

	// 过滤
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 把请求对象强转成http
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 连接数据库查询数据库的新闻信息
		INewsService newsService = new NewsServiceImpl();
		List<News> list = null;
		try {
			list = newsService.showNews();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		HttpSession session = req.getSession();
		session.setAttribute("index_news", list);
		chain.doFilter(req, resp);
	}

	// 初始化
	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
