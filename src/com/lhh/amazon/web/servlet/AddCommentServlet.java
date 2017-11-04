package com.lhh.amazon.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Comment;
import com.lhh.amazon.service.ICommentService;
import com.lhh.amazon.service.impl.CommentServiceImpl;

@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCommentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取内容
		String nickname = request.getParameter("guestName");
		// String title = request.getParameter("guestTitle");
		String content = request.getParameter("guestContent");

		// 获取当前的日期
		Date date = new Date();

		ICommentService commentService = new CommentServiceImpl();
		Comment comment = new Comment();

		comment.setNickname(nickname);
		comment.setContent(content);
		comment.setCreateTime(date);

		try {
			commentService.createComment(comment);
			// 创建成功，刷新页面
			response.sendRedirect("guestbook.jsp");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
