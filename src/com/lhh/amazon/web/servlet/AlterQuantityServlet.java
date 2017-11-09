package com.lhh.amazon.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.impl.CartServiceImpl;

@WebServlet("/alterQuantity")
public class AlterQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterQuantityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long cid = Long.parseLong(request.getParameter("cid"));
		int quantity = Integer.parseInt(request.getParameter("count"));

		ICartService ics = new CartServiceImpl();
		// 更新数据库
		try {
			ics.updateCart(cid, quantity);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
