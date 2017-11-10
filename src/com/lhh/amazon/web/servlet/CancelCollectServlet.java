package com.lhh.amazon.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

@WebServlet("/cancel")
public class CancelCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CancelCollectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取商品的ID
		Long pid = Long.parseLong(request.getParameter("id"));
		IProductService ips = new ProductServicempl();

		byte status = 0;
		try {
			ips.updateStatus(pid, status);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		response.sendRedirect("my_collect.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
