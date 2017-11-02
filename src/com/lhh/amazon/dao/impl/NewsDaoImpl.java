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
import com.lhh.amazon.dao.INewsDao;
import com.lhh.amazon.entity.News;

public class NewsDaoImpl implements INewsDao {

	// 插入一条新闻
	public News insert(Connection conn, News news) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		// SQL语句 查询序列
		String selectSQL = "select SEQ_NEWS.nextval from dual";
		jt.query(selectSQL, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					news.setNewsID(rs.getLong(1));
				}
			}
		});

		// 插入SQL语句
		String insertSQL = "insert into hwua_news values(?,?,?,?)";
		jt.update(insertSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, news.getNewsID());
				pstmt.setString(2, news.getTitle());
				pstmt.setString(3, news.getContent());
				pstmt.setDate(4, new java.sql.Date(news.getCreateTime().getTime()));
			}
		});
		return news;
	}

	// 查询新闻
	@Override
	public List<News> select(Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		List<News> list = new ArrayList<News>();
		// 查询SQL语句
		String sql = "select * from hwua_news";
		jt.query(sql, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					News news = new News();
					news.setNewsID(rs.getLong(1));
					news.setTitle(rs.getString(2));
					news.setContent(rs.getString(3));
					news.setCreateTime(rs.getDate(4));
					list.add(news);
				}
			}
		});
		return list;
	}

	@Override
	public News select(Long id, Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		News news = new News();
		// 查询SQL语句
		String sql = "select * from hwua_news where hn_id = ?";
		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, id);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					news.setNewsID(rs.getLong(1));
					news.setTitle(rs.getString(2));
					news.setContent(rs.getString(3));
					news.setCreateTime(rs.getDate(4));
				}
			}
		});
		return news;
	}

	// @Override
	// public List<News> select() throws DataAccessException {
	// Connection conn = null;
	// JdbcTemplate jt = new JdbcTemplate(conn);
	// List<News> list = new ArrayList<News>();
	// // 查询SQL语句
	// String sql = "select * from hwua_news";
	// jt.query(sql, new RowCallBackHandler() {
	//
	// @Override
	// public void processRow(ResultSet rs) throws SQLException {
	// while (rs.next()) {
	// News news = new News();
	// news.setNewsID(rs.getLong(1));
	// news.setTitle(rs.getString(2));
	// news.setContent(rs.getString(3));
	// news.setCreateTime(rs.getDate(4));
	// list.add(news);
	// }
	// }
	// });
	// return list;
	// }

}
