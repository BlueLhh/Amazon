package com.lhh.amazon.service.impl;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.ConnectionFactory;
import com.lhh.amazon.common.DBUtils;
import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.dao.ICommentDao;
import com.lhh.amazon.dao.impl.CommentDaoImpl;
import com.lhh.amazon.entity.Comment;
import com.lhh.amazon.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	private ICommentDao dao;

	public CommentServiceImpl() {
		dao = new CommentDaoImpl();
	}

	// 创建一条留言信息
	@Override
	public Comment createComment(Comment comment) throws ServiceException {
		Connection conn = null;

		conn = ConnectionFactory.getConnection();
		try {
			comment = dao.insert(conn, comment);
		} catch (DataAccessException e) {
			throw new ServiceException("留言失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return comment;
	}

	// 显示全部的留言信息
	@Override
	public List<Comment> allComment(Comment comment) throws ServiceException {

		Connection conn = null;
		List<Comment> list = null;
		conn = ConnectionFactory.getConnection();

		try {
			list = dao.select(conn);
		} catch (DataAccessException e) {
			throw new ServiceException("显示失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return list;
	}

	@Override
	public List<Comment> allComment() throws ServiceException {
		Connection conn = null;
		List<Comment> list = null;
		conn = ConnectionFactory.getConnection();

		try {
			list = dao.select(conn);
		} catch (DataAccessException e) {
			throw new ServiceException("显示失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return list;
	}
}
