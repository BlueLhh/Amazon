package com.lhh.amazon.dao;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.Comment;

public interface ICommentDao {
	/**
	 * 创建一条留言
	 * 
	 * @param conn
	 * @param comment
	 * @return
	 * @throws DataAccessException
	 */
	public Comment insert(Connection conn, Comment comment) throws DataAccessException;

	/**
	 * 
	 * 显示全部的留言
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	public List<Comment> select(Connection conn) throws DataAccessException;

	// List<Comment> select(Connection conn) throws DataAccessException;
}
