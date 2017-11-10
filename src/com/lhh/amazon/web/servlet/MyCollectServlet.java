package com.lhh.amazon.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/MyCollectServlet")
public class MyCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyCollectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IProductService ips = new ProductServicempl();
		List<Product> list = null;
		List<String> condition = new ArrayList<String>();
		byte status = 1;
		condition.add("hp_status = " + status);
		try {
			list = ips.showProduct(condition);
			for (Product product : list) {
				System.out.println(product);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("list", list);

		response.sendRedirect("my_collect.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
