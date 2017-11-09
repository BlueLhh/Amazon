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

@WebServlet("/pview")
public class ProductPviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductPviewServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取点击之后的ID
		String id = request.getParameter("id");
		Long productID = Long.parseLong(id);
		/* 这是获取点击的商品ID之后跳转到的显示商品详细信息的界面 */
		IProductService ips = new ProductServicempl();
		Product product = new Product();
		// 设置一个商品集合 用来显示最近浏览
		List<Product> pList;
		// 设置一个集合用来存储商品的ID 看看是否相同
		List<Long> pidList = new ArrayList<Long>();
		// new 一个session对象
		HttpSession session = request.getSession();

		try {
			// 通过ID来查询商品 显示全部的商品信息 并且在实现最近浏览功能也需要用到
			product = ips.findProduct(productID);

			// 最近浏览功能开始 //
			// 设置一个Object 用来存储点击的商品
			Object obj = session.getAttribute("Repro");
			Object pid = session.getAttribute("proID");
			// 判断如果已经存在
			if (obj != null && pid != null) {
				// 点击的商品已经存在 赋值为最新点击的商品
				pList = (List<Product>) obj;
				// pid
				pidList = (List<Long>) pid;
				// 判断小于4的时候
				if (pList.size() < 4 && pList.size() != 0) {
					// 判断是否存在相同的商品 根据ID判断
					if (!pidList.contains(product.getProductID())) {
						// 不存在 则存在第一个
						pList.add(0, product);
						// 存当前的ID
						pidList.add(product.getProductID());
					} else {
						// 如果存在相同的ID 则删除该信息 再把新的信息写在第一行
						for (Product p : pList) {
							if (p.getProductID() == productID) {
								pList.remove(p);
								// pidList.remove(p.getProductID());
								break;
							}
						}
						pList.add(0, product);
						// pidList.add(product.getProductID());
					}
				} else {
					if (!pidList.contains(product.getProductID())) {
						// 不存在 则存在第一个
						pList.add(0, product);
						// 删除最后一个
						pList.remove(pList.size() - 1);
						// 存在当前的ID
						pidList.add(product.getProductID());
					} else {
						// 如果存在相同的ID 则删除该信息 再把新的信息写在第一行
						for (Product p : pList) {
							if (p.getProductID() == productID) {
								pList.remove(p);
								// pidList.remove(p.getProductID());
								break;
							}
						}
						pList.add(0, product);
						// pidList.add(product.getProductID());
					}
				}
			} else {
				pList = new ArrayList<Product>();
				if (product != null && product.getProductID() != -1) {
					pList.add(product);
					pidList.add(product.getProductID());
				}
			}
			// 存储id
			session.setAttribute("proID", pidList);
			// 存储被点击的商品
			session.setAttribute("Repro", pList);
			// 最近浏览功能结束 //
			// 查找成功，保存
			request.setAttribute("product", product);
			// 跳转界面
			// response.sendRedirect("product_view.jsp");
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
