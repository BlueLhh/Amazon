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

//query
@WebServlet("/query")
public class QueryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// 获取想要搜索的商品名称
		String qname = request.getParameter("qname");
		// 查询全部的商品
		IProductService ips = new ProductServicempl();
		List<Product> list = null;
		int allPage = 0;
		int page = 1;// 初次到首页，默认为1
		// 写条件 不写条件的时候 默认查询全部的商品
		List<String> condition = new ArrayList<String>();
		// 条件查询
		condition.add("hp_name like '%" + qname + "%'");
		try {
			// list = ips.allProduct();
			list = ips.showProduct(condition, page);
			allPage = ips.totalPage(condition);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		// 有相关信息
		// 保存
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		session.setAttribute("product", list);
		session.setAttribute("page", allPage);
		request.setAttribute("pageNow", page);
		// 使用分发器
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
