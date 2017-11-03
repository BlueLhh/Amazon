package com.lhh.amazon.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

//@WebFilter(filterName = "ProductPviewFilter", urlPatterns = { "/product_view.jsp", "/pview" })
public class ProductPviewFilter implements Filter {
	public ProductPviewFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String id = request.getParameter("id");
		Long productID = Long.parseLong(id);
		System.out.println("ID为："+id);
		IProductService ips = new ProductServicempl();
		Product product = new Product();

		try {
			product = ips.findProduct(productID);
			System.out.println(product);
			// 查找成功，保存
			request.setAttribute("product", product);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		// 放行进入下一资源
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
