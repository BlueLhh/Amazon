package com.lhh.amazon.web.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.IOrderService;
import com.lhh.amazon.service.impl.OrderServiceImpl;

@WebFilter("/my_order.jsp")
public class MyOrderFilter implements Filter {

	public MyOrderFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		IOrderService ios = new OrderServiceImpl();
		// 获取当前的用户 根据当前的用户ID获取全部的订单
		Long userid = ((User) req.getSession().getAttribute("user")).getUserID();
		List<Order> list = null;
		try {
			list = ios.userAllOrder(userid);
			// 进行降序排序
			Collections.sort(list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		session.setAttribute("list", list);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
