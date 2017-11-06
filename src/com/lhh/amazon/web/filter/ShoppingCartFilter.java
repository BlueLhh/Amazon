package com.lhh.amazon.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.impl.CartServiceImpl;

@WebFilter("/ShoppingCartFilter")
public class ShoppingCartFilter implements Filter {

	public ShoppingCartFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		ICartService ics = new CartServiceImpl();
		List<Cart> list;
		// 获取当前的用户id
		Long userid = ((User) req.getSession().getAttribute("user")).getUserID();
		System.out.println("当前的用户ID=" + userid);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
