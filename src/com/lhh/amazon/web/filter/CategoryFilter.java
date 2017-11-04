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
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.ProductCategory;
import com.lhh.amazon.service.IProductCategoryService;
import com.lhh.amazon.service.impl.ProductCategoryServiceImpl;

@WebFilter(filterName = "CategoryFilter", urlPatterns = { "/index.jsp", "/guestbook.jsp", "/index_product_sort.jsp",
		"/pview" })
public class CategoryFilter implements Filter {

	public CategoryFilter() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 查询
		IProductCategoryService ipcs = new ProductCategoryServiceImpl();
		List<ProductCategory> list = null;

		try {
			list = ipcs.findCategory();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		// 查询成功
		// 保存
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		session.setAttribute("Category", list);
		// 放行资源
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
