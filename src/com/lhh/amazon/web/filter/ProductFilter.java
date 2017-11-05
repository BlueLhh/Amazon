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
		int allPage = 0;
		int page = 1;// 初次到首页，默认为1
		// 写条件 不写条件的时候 默认查询全部的商品
		List<String> condition = new ArrayList<String>();
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
		// 放行资源
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
