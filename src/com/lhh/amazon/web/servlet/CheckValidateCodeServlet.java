package com.lhh.amazon.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * 验证码servlet
 * 
 * @author 46512
 *
 */
@WebServlet("/checkCode")
public class CheckValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckValidateCodeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取jsp界面输入框的验证码
		String jspCode = request.getParameter("veryCode");
		// 获取生成的验证码
		HttpSession session = request.getSession();
		String sysCode = session.getAttribute("validateCode").toString();
		if (jspCode.equals(sysCode)) {
			// 验证码正确
			response.getWriter().write(1 + "");
		} else {
			// 验证码错误
			response.getWriter().write(false + "");
			// 销毁验证码
			// session.invalidate();
			// 刷新
			// String str = request.getHeader("Referer");
			// String[] split = str.split("Amazon/");
			//
			// System.out.println(split[1]);
			// response.getWriter().write("<script>location.href='" + split[1] +
			// "'</script>");
			// response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
