package com.lhh.amazon.web.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.IOrderService;
import com.lhh.amazon.service.impl.OrderServiceImpl;

// 用过滤器比较好
//@WebServlet("/MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		IOrderService ios = new OrderServiceImpl();
		// 获取当前的用户 根据当前的用户ID获取全部的订单
		Long userid = ((User) request.getSession().getAttribute("user")).getUserID();
		List<Order> list = null;
		try {
			list = ios.userAllOrder(userid);
			// 进行降序排序
			Collections.sort(list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		session.setAttribute("list", list);
		response.sendRedirect("my_order.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
