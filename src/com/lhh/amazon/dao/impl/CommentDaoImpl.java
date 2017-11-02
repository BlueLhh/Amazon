package com.lhh.amazon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.JdbcTemplate;
import com.lhh.amazon.common.PreparedStatementSetter;
import com.lhh.amazon.common.RowCallBackHandler;
import com.lhh.amazon.dao.ICommentDao;
import com.lhh.amazon.entity.Comment;

public class CommentDaoImpl implements ICommentDao {

	// 创建一条留言
	@Override
	public Comment insert(Connection conn, Comment comment) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		// sql语句
		String sql = "select SEQ_COMMENT.nextval from dual";
		jt.query(sql, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					comment.setCommentID(rs.getLong(1));
				}
			}
		});

		// 插入sql语句
		String insertSQL = "insert into hwua_comment values(?,?,?,?,?,?,?)";
		jt.update(insertSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, comment.getCommentID());
				pstmt.setString(2, comment.getReply());
				pstmt.setString(3, comment.getContent());
				pstmt.setDate(4, new java.sql.Date(comment.getCreateTime().getTime()));
				if (comment.getReplyTime() == null) {
					pstmt.setDate(5, null);
				} else {
					pstmt.setDate(5, new java.sql.Date(comment.getReplyTime().getTime()));
				}
				pstmt.setString(6, comment.getNickname());
				pstmt.setString(7, comment.getState());
			}
		});
		return comment;
	}

	// 查询留言
	@Override
	public List<Comment> select(Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		List<Comment> list = new ArrayList<Comment>();
		// 查询SQL语句
		String sql = "select * from hwua_comment";
		jt.query(sql, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Comment comment = new Comment();
					comment.setCommentID(rs.getLong(1));
					comment.setReply(rs.getString(2));
					comment.setContent(rs.getString(3));
					comment.setCreateTime(rs.getDate(4));
					comment.setReplyTime(rs.getDate(5));
					comment.setNickname(rs.getString(6));
					comment.setState(rs.getString(7));
					list.add(comment);
				}
			}
		});
		return list;
	}

	// @Override
	// public List<Comment> select() throws DataAccessException {
	//
	// return null;
	// }
}
