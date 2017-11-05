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

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IProductService ips = new ProductServicempl();
		// 写条件
		List<String> conditions = new ArrayList<String>();
		// 定义id
		Long id;
		int page = 1;// 初始页数为1
		int allPage = 0;
		List<Product> list = null;
		String cate = request.getParameter("cate");
		if (cate.equals("max") && cate != null) {
			// 获取index_product_sort.jsp界面的hpc_parent_id
			String parentID = request.getParameter("hpc_parent_id");
			// 强转获取的ID为Long
			id = Long.parseLong(parentID);
			conditions.add("hpc_id = " + id);
			try {
				// 通过父级查找商品的信息
				// list = ips.showProduct(conditions);
				list = ips.showProduct(conditions, page);
				// request.setAttribute("product", list);
				allPage = ips.totalPage(conditions);
				// System.out.println("父级的页数为：" + page + 1);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		} else if (cate.equals("min") && cate != null) {
			// 获取index_product_sort.jsp界面的hpc_id
			String childID = request.getParameter("hpc_id");
			id = Long.parseLong(childID);
			conditions.add("hpc_child_id = " + id);
			try {
				// 通过子级查找商品的信息
				// list = ips.showProduct(conditions);
				list = ips.showProduct(conditions, page);
				allPage = ips.totalPage(conditions);
				// request.setAttribute("product", list);
				// System.out.println("子级的页数为：" + page + 1);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		session.setAttribute("product", list);
		session.setAttribute("page", allPage);
		request.setAttribute("pageNow", page);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
