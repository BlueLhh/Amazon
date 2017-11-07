package com.lhh.amazon.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.impl.CartServiceImpl;

@WebServlet("/goingToBuy")
public class GoingToBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GoingToBuyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 点击的时候获取商品的pid和数量
		Long pid = Long.parseLong(request.getParameter("pid"));
		// 数量
		int count = Integer.parseInt(request.getParameter("count"));
		// 获取当前用户的ID
		Long userid = ((User) request.getSession().getAttribute("user")).getUserID();
		// 已知数量和ID还有用户ID 进行添加到购物车
		ICartService ics = new CartServiceImpl();
		Cart cart = new Cart();
		// 先进行查询购物车内是否已经存在商品 如果存在则在基础上添加商品
		// 不存在则进行新增新的商品信息
		// 初始化不存在
		boolean isExisted = false;
		try {
			isExisted = ics.checkCart(pid, userid);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (isExisted) {
			// 存在 更新数量
			// 查询存在的数据库的数量
			try {
				cart = ics.findCart(pid, userid);
				int quantity = cart.getQuantity();
				quantity = quantity + count;
				ics.updateCart(pid, userid, quantity);
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		} else {
			// 不存在 创建新的
			cart.getProduct().setProductID(pid);
			cart.setQuantity(count);
			cart.setUserID(userid);
			try {
				ics.createCart(cart);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("shopping.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
