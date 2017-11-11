package com.lhh.amazon.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.IUserService;
import com.lhh.amazon.service.impl.UserServiceImpl;

// 找回密码
@WebServlet("/retrievePassWordServlet")
public class RetrievePassWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RetrievePassWordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取输入的用户名 手机号 邮箱
		String username = request.getParameter("userName");
		String phone = request.getParameter("uPhone");
		String email = request.getParameter("email");
		IUserService userService = new UserServiceImpl();
		User user = null;
		// 是否存在
		boolean isExisted = false;
		try {
			isExisted = userService.chcekUser(username, phone, email);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (isExisted) {
			// 存在
			// response.getWriter().write(1 + "");
			try {
				user = userService.findUser(username);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			String password = user.getPassword();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter()
					.write("<script>javascript:alert('你的密码为：" + password + "');location.href='login.jsp'</script>");
		} else {
			// 不存在
			// response.getWriter().write(isExisted + "");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter()
					.write("<script>javascript:alert('用户不存在，请重新输入信息！');location.href='retrieve_password.jsp'</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
