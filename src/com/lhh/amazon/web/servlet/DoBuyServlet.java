package com.lhh.amazon.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.entity.OrderDetail;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.IOrderDetailService;
import com.lhh.amazon.service.IOrderService;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.CartServiceImpl;
import com.lhh.amazon.service.impl.OrderDetailServiceImpl;
import com.lhh.amazon.service.impl.OrderServiceImpl;
import com.lhh.amazon.service.impl.ProductServicempl;

@WebServlet("/doBuy")
public class DoBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoBuyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ICartService ics = new CartServiceImpl();
		IProductService ips = new ProductServicempl();
		IOrderService ios = new OrderServiceImpl();
		Order order = new Order();
		// 获取当前用户的ID
		Long userid = ((User) request.getSession().getAttribute("user")).getUserID();
		// 获取当前用户的名字
		String username = ((User) request.getSession().getAttribute("user")).getUsername();
		// 获取当前用户的地址
		String useraddress = ((User) request.getSession().getAttribute("user")).getAddress();
		List<Cart> cList;
		// List<Product> pList = null;
		Product product = null;
		double orderCost = 0;// 订单总额
		double odtCost = 0;// 子订单金额

		try {
			// 通过用户ID进行查询购物车
			cList = ics.showCart(userid);
			for (Cart cart : cList) {
				// 商品的ID
				Long pid;
				pid = cart.getProduct().getProductID();
				// 通过商品的ID进行查找该商品
				product = ips.findProduct(pid);
				// 获取该购物车内的商品的总价
				orderCost += product.getPrice() * cart.getQuantity();
			}
			// 获取时间戳作为订单的ID
			Date time = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Long orderid = Long.parseLong(sdf.format(time));
			// 初始化状态和类别 都为0
			int status = 0;
			int type = 0;
			// 开始添加订单
			order.setOrderID(orderid);
			order.getUser().setUserID(userid);
			order.setUsername(username);
			order.setUserAddress(useraddress);
			order.setCreateTime(time);
			order.setCost(orderCost);
			order.setStatus(status);
			order.setType(type);
			// 执行添加订单
			ios.creatOrder(order);

			// 添加到子订单
			for (Cart cart : cList) {
				Long pid;
				int quantity;// 商品的数量
				// 商品订单
				pid = cart.getProduct().getProductID();
				product = ips.findProduct(pid);
				quantity = cart.getQuantity();
				odtCost = product.getPrice() * quantity;
				// 开始添加子订单
				IOrderDetailService ids = new OrderDetailServiceImpl();
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.getOrder().setOrderID(orderid);
				orderDetail.getProduct().setProductID(pid);
				orderDetail.setQuantity(quantity);
				orderDetail.setCost(odtCost);
				ids.creatOD(orderDetail);
			}

			for (Cart cart : cList) {
				Long pid;
				@SuppressWarnings("unused")
				int quantity;// 购物车商品的数量
				int stock;// 库存
				// 商品订单ID
				pid = cart.getProduct().getProductID();
				// 购买的商品的数量
				quantity = cart.getQuantity();
				// 查询商品
				product = ips.findProduct(pid);
				// 用商品的库存减去购物车内的数量
				stock = product.getStock() - cart.getQuantity();
				// 根据商品的ID进行库存的修改
				ips.updateStock(pid, stock);
			}
			// 清空购物车
			ics.deleteAllCart(userid);
			// 查询订单
			order = ios.findOrder(orderid);
			// 将订单保存
			HttpSession session = request.getSession();
			session.setAttribute("order", order);
			// 跳转到下一页
			RequestDispatcher rd = request.getRequestDispatcher("shopping-result.jsp");
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
