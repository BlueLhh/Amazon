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

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

//@WebFilter("/index.jsp")
@WebFilter(filterName = "ProductFilter", urlPatterns = { "/index.jsp", "/ProductServlet" })
public class ProductFilter implements Filter {

	public ProductFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 查询全部的商品
		IProductService ips = new ProductServicempl();
		List<Product> list = null;

		try {
			list = ips.allProduct();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		if (list.size() > -1) {
			// 有相关信息
			// 保存
			request.setAttribute("product", list);
			// 放行资源
			chain.doFilter(request, response);
		} else {
			System.out.println("没有相关信息");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
