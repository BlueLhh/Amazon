package com.lhh.amazon.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.IUserService;
import com.lhh.amazon.service.impl.UserServiceImpl;

@WebServlet("/MySelfServlet")
public class MySelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MySelfServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//
		User user = ((User) request.getSession().getAttribute("user"));
		Long userid = user.getUserID();
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		byte sex = user.getSex();
		String data = request.getParameter("birthday");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String identityCode = user.getIdentityCode();
		String email = request.getParameter("email");
		String phone = request.getParameter("mobile");
		String address = request.getParameter("address");
		int status = user.getStatus();

		IUserService ius = new UserServiceImpl();
		User users = new User();
		users.setUserID(userid);
		users.setUsername(username);
		users.setPassword(password);
		users.setSex(sex);
		users.setBirthday(birthday);
		users.setIdentityCode(identityCode);
		users.setEmail(email);
		users.setMobile(phone);
		users.setAddress(address);
		users.setStatus(status);
		try {
			ius.updateUser(users);
			// 更新成功！销毁 user 跳转到登录界面
			// request.getSession().setMaxInactiveInterval();
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			// 跳转到登录界面
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>javascript:alert('更新成功，请重新登录！');location.href='login.jsp'</script>");
			// response.sendRedirect("/login.jsp");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
