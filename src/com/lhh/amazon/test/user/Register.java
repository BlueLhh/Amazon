package com.lhh.amazon.test.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.IUserService;
import com.lhh.amazon.service.impl.UserServiceImpl;

public class Register {
	public static void main(String[] args) {
		String username;// 用户名字
		String password;// 用户密码
		byte sex;// 性别
		Date birthday = null;// 生日
		String identityCode;// 身份证
		String email;// 邮箱
		String mobile;// 手机
		String address;// 住址
		//int status;// 状态
		// 强转时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("姓名：");
		username = sc.next();
		System.out.println("密码：");
		password = sc.next();
		System.out.println("性别（0男1女）：");
		sex = sc.nextByte();
		System.out.println("生日：");
		String str = sc.next();
		try {
			birthday = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("身份证：");
		identityCode = sc.next();
		System.out.println("邮箱：");
		email = sc.next();
		System.out.println("手机：");
		mobile = sc.next();
		System.out.println("住址：");
		address = sc.next();
//		System.out.println("状态：");
//		status = sc.nextInt();

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
		//user.setStatus(status);
		try {
			userService.register(user);
			System.out.println("注册成功！");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
