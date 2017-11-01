package com.lhh.amazon.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.service.IUserService;
import com.lhh.amazon.service.impl.UserServiceImpl;

@WebServlet("/CheckNameServlet")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckNameServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		IUserService userService = new UserServiceImpl();
		// 是否存在
		boolean isExisted = false;
		try {
			isExisted = userService.checkName(username); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (isExisted) {
			response.getWriter().write(1 + "");
		} else {
			response.getWriter().write(isExisted + "");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
