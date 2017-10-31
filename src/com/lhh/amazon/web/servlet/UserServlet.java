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

@WebServlet("/user/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op.equals("reg")) {
			String username = request.getParameter("userName");
			String password = request.getParameter("passWord");
			String getsex = request.getParameter("sex");
			byte sex = (byte) Integer.parseInt(getsex);
			String data = request.getParameter("birthday");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = null;
			try {
				birthday = format.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String identityCode = request.getParameter("identity");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			IUserService userService = new UserServiceImpl();
			User user = new User();

			user.setUsername(username);
			user.setPassword(password);
			user.setSex(sex);
			user.setBirthday(birthday);
			user.setIdentityCode(identityCode);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setAddress(address);

			try {
				user = userService.register(user);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println("注册成功！");
				response.sendRedirect("../index.jsp");
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		} else if (op.equals("login")) {
			String username = request.getParameter("userName");
			String password = request.getParameter("passWord");
			IUserService userService = new UserServiceImpl();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			try {
				user = userService.login(username, password);
				System.out.println("数据库中提取出来的用户名：" + user.getUsername());
				System.out.println("数据库中提取出来的密码：" + user.getPassword());
				if (user != null && user.getUserID() != -1) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("../index.jsp");
					System.out.println("登录成功！");
				} else {
					System.out.println("用户名或者密码错误！");
					System.out.println("用户名：" + username);
					System.out.println("密码：" + password);
					//登录不成功，继续返回登录的界面
					response.sendRedirect("../login.jsp");
				}
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}else if(op.equals("logout")){
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect("../login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
