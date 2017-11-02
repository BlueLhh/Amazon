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

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Comment;
import com.lhh.amazon.service.ICommentService;
import com.lhh.amazon.service.impl.CommentServiceImpl;

@WebFilter("/guestbook.jsp")
public class GuestbookFliter implements Filter {

	public GuestbookFliter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 查询留言信息
		ICommentService commentService = new CommentServiceImpl();
		List<Comment> list = null;

		try {
			list = commentService.allComment();
			if (list.size() > -1) {
				// 存在留言信息
				// 保存到request。用requertScope提取
				request.setAttribute("comment", list);
				// 放行资源
				chain.doFilter(request, response);
			} else {
				// 不存在信息
				System.out.println("不存在留言！");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
