package com.lhh.amazon.web.filter;

import java.io.IOException;
import java.util.ArrayList;
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
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

@WebFilter("/my_collect.jsp")
public class MyCollectFilter implements Filter {

	public MyCollectFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		IProductService ips = new ProductServicempl();
		List<Product> list = null;
		List<String> condition = new ArrayList<String>();
		byte status = 1;
		condition.add("hp_status = " + status);
		try {
			list = ips.showProduct(condition);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
