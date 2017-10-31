package com.lhh.amazon.test.user;

import java.util.Scanner;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.service.IUserService;
import com.lhh.amazon.service.impl.UserServiceImpl;

/**
 * 
 * 查找存在的用户
 * @author 46512
 *
 */
public class FindName {
	public static void main(String[] args) {
		String username;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入姓名：");
		username = sc.next();
		IUserService user = new UserServiceImpl();
		//是否存在  初始化为不存在
		boolean isExisted = false;
		try {
			isExisted = user.checkName(username);
			if(isExisted){
				System.out.println("用户名存在");
			}else{
				System.out.println("用户名不存在");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
