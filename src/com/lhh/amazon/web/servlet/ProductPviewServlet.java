package com.lhh.amazon.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

@WebServlet("/pview")
public class ProductPviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductPviewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取点击之后的ID
		String id = request.getParameter("id");
		Long productID = Long.parseLong(id);
		
		IProductService ips = new ProductServicempl();
		Product product = new Product();
		
		try {
			product = ips.findProduct(productID);
			//查找成功，保存
			request.setAttribute("product", product);
			//跳转界面
			//response.sendRedirect("product_view.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("product_view.jsp");
			rd.forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
