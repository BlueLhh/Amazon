package com.lhh.amazon.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

@WebServlet("/ref")
public class RefProdcutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RefProdcutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String getPage = request.getParameter("page");
		int page = Integer.parseInt(getPage);
		// 查询全部的商品
		IProductService ips = new ProductServicempl();
		List<Product> list = null;
		List<String> condition = new ArrayList<String>();
		try {
			list = ips.showProduct(condition, page);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		// 使用分发器
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		session.setAttribute("product", list);
		request.setAttribute("pageNow", page);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
