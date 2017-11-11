package com.lhh.amazon.dao;

import java.sql.Connection;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.User;

public interface IUserDao {
	/**
	 * 插入数据
	 * 
	 * @param conn
	 * @param user
	 * @throws DataAccessException
	 */
	public User insert(Connection conn, User user) throws DataAccessException;

	/**
	 * 
	 * 查询数据
	 * 
	 * @param conn
	 * @param username
	 * @param password
	 * @throws DataAccessException
	 */
	public User select(Connection conn, String username, String password) throws DataAccessException;

	// 用于判断一个用户是否存在
	public User select(Connection conn, String username, String phone, String email) throws DataAccessException;

	public User select(Connection conn, String username) throws DataAccessException;

	// 修改个人中心的信息
	public void update(User user, Connection conn) throws DataAccessException;

}
