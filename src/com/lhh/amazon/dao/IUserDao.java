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
	public void insert(Connection conn, User user) throws DataAccessException;

	/**
	 * 
	 * 查询数据
	 * 
	 * @param conn
	 * @param username
	 * @param password
	 * @throws DataAccessException
	 */
	public void query(Connection conn, String username, String password) throws DataAccessException;

	public void query(Connection conn, String username) throws DataAccessException;
}
