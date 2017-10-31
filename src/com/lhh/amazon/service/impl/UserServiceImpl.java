package com.lhh.amazon.service.impl;

import java.sql.Connection;

import com.lhh.amazon.common.ConnectionFactory;
import com.lhh.amazon.common.DBUtils;
import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.dao.IUserDao;
import com.lhh.amazon.dao.impl.UserDaoImpl;
import com.lhh.amazon.entity.User;
import com.lhh.amazon.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao dao;

	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public User login(String username, String password) throws ServiceException {
		Connection conn = null;
		User user;
		try {
			// 连接数据库
			conn = ConnectionFactory.getConnection();
			user = dao.select(conn, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("登录失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return user;
	}

	// 查询姓名是否存在
	@Override
	public boolean checkName(String username) throws ServiceException {
		Connection conn = null;
		User user;
		try {
			// 连接数据库
			conn = ConnectionFactory.getConnection();
			user = dao.select(conn, username);
		} catch (Exception e) {
			throw new ServiceException("查找失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		if (user == null || user.getUserID() == -1) {
			// 不存在
			return false;
		} else {
			// 存在
			return true;
		}
	}

	// 注册
	@Override
	public User register(User user) throws ServiceException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			user = dao.insert(conn, user);
		} catch (Exception e) {
			throw new ServiceException("注册失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return user;
	}
}
