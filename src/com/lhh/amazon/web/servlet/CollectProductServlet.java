package com.lhh.amazon.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

@WebServlet("/collect")
public class CollectProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CollectProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IProductService ips = new ProductServicempl();
		// 获取商品的ID
		Long pid = Long.parseLong(request.getParameter("id"));
		// 获取选择
		String op = request.getParameter("op");
		// 设置状态
		byte status;

		if (op.equals("ok")) {
			// ok选择收藏
			status = 1; // 1表示收藏
			try {
				ips.updateStatus(pid, status);
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		} else {
			// no 取消收藏
			status = 0;
			try {
				ips.updateStatus(pid, status);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		// // 分发器 请求和相应
		// RequestDispatcher rd =
		// request.getRequestDispatcher("product_view.jsp");
		// rd.forward(request, response);
		HttpSession session = request.getSession();
		session.setAttribute("pid", pid);
		response.sendRedirect("product_view.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
