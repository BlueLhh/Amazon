package com.lhh.amazon.test.user;

import java.util.Scanner;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.IUserService;
import com.lhh.amazon.service.impl.UserServiceImpl;

public class Login {
	public static void main(String[] args) {
		String username;
		String password;
		IUserService userService = new UserServiceImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入账号：");
		username = sc.next();
		System.out.print("请输入密码：");
		password = sc.next();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		try {
			user = userService.login(username, password);
			if (user != null && user.getUserID() != -1) {
				System.out.println("登录成功！");
			}else{
				System.out.println("登录失败！");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
