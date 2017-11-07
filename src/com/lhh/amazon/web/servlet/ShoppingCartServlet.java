package com.lhh.amazon.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.CartServiceImpl;
import com.lhh.amazon.service.impl.ProductServicempl;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取当前的用户的ID
		Long userid = ((User) request.getSession().getAttribute("user")).getUserID();
		// 根据用户的ID进行查询购物车内的信息
		ICartService ics = new CartServiceImpl();
		// 查询商品表信息
		IProductService ips = new ProductServicempl();
		// 存储查询出来的商品
		// List<Product> pList = new ArrayList<Product>();
		// 用来查找商品的信息
		Product product;
		// 用来存储购物车的信息
		List<Cart> cList;

		try {
			// 通过当前的用户id来查找所有的购物车信息
			cList = ics.showCart(userid);
			for (Cart cart : cList) {
				// 每次循环一次就获取一个ID
				Long id = cart.getProduct().getProductID();
				// 根据id进行查询商品
				product = ips.findProduct(id);
				// 存储
				cart.setProduct(product);
				// pList.add(product);
			}
			// 存入request中
			// request.setAttribute("product", pList);
			HttpSession session = request.getSession();
			session.setAttribute("cart", cList);
			// 跳转到购物车
			RequestDispatcher rd = request.getRequestDispatcher("shopping.jsp");
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
