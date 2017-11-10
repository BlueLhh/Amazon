package com.lhh.amazon.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.service.IOrderService;
import com.lhh.amazon.service.impl.OrderServiceImpl;

@WebServlet("/orderOperation")
public class OrderOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderOperationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IOrderService ios = new OrderServiceImpl();
		// 获取ORDERID 和 op
		Long orderid = Long.parseLong(request.getParameter("orderid"));
		// rec为确认收货 del为确认删除订单
		String op = request.getParameter("op");
		if (op.equals("rec")) {
			// 确认收货 更改订单的状态
			try {
				ios.updateOrder(orderid);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		} else {
			// 删除订单
			try {
				ios.updateDel(orderid);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		// 重定向 更新
		response.sendRedirect("my_order.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
