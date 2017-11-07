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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.HotSale;
import com.lhh.amazon.service.IOrderDetailService;
import com.lhh.amazon.service.impl.OrderDetailServiceImpl;

@WebFilter(filterName = "HotSaleFilter", urlPatterns = { "/index.jsp", "/hotproduct.jsp" })
public class HotSaleFilter implements Filter {

	public HotSaleFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		IOrderDetailService iods = new OrderDetailServiceImpl();
		List<HotSale> list = new ArrayList<HotSale>();
		try {
			list = iods.hotSale();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		session.setAttribute("hotSale", list);
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
