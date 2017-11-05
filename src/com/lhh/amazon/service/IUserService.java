package com.lhh.amazon.service;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.User;

public interface IUserService {
	// 登录
	public User login(String username, String password) throws ServiceException;

	// 检测用户是否存在
	public boolean checkName(String username) throws ServiceException;

	// 通过名字查询用户
	public User findUser(String username) throws ServiceException;

	// 注册
	public User register(User user) throws ServiceException;
}
