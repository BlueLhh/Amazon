package com.lhh.amazon.web.filter;

import java.io.IOException;
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

@WebFilter("/product_view.jsp")
public class ProductViewFilter implements Filter {

	public ProductViewFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		IProductService ips = new ProductServicempl();
//		Long pid = Long.parseLong(request.getParameter("id"));
		Long pid = (Long) session.getAttribute("pid");
		// 更新成功之后 重新查询
		Product product = new Product();
		try {
			product = ips.findProduct(pid);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		// 存储到session

		request.setAttribute("product", product);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
