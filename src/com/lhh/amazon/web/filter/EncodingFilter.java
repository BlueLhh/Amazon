package com.lhh.amazon.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 中文乱码过滤器
 * 
 * @author 46512
 *
 */
@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "encoding", value = "utf-8") })
public class EncodingFilter implements Filter {

	private String encoding = "gbk";// 字符编码

	// 初始化
	@Override
	public void init(FilterConfig config) throws ServletException {
		// 获取encoding
		String value = config.getInitParameter("encoding");
		// 判断，如果value为空，则encoding的编码为 gbk
		if (value != null && !value.equals("")) {
			encoding = value;
		}
	}

	// 过滤方法，在访问指定资源前后都经过此方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 把请求和相应对象强转成http的
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 设置请求的编码，进队post请求有效，get无效
		req.setCharacterEncoding(encoding);
		// 设置相应的编码
		resp.setContentType("text/html;charset=" + encoding);
		// 注意，如果要方形，必须调用此方法，否则会阻塞在本过滤器中
		chain.doFilter(req, resp);
	}

	// 销毁
	@Override
	public void destroy() {
	}

}
