package com.lhh.amazon.test.user;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.IUserService;
import com.lhh.amazon.service.impl.UserServiceImpl;

/**
 * 
 * 测试查找用户
 * 
 * @author 46512
 *
 */
public class FindUser {
	public static void main(String[] args) {
		String username = "admin";
		IUserService iuser = new UserServiceImpl();
		User user;
		try {
			user = iuser.findUser(username);
			// 找到了
			System.out.println(user);
			// 根据找到的用户查找ID
			System.out.println("用户的ID为：" + user.getUserID());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
