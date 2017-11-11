package com.lhh.amazon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.JdbcTemplate;
import com.lhh.amazon.common.PreparedStatementSetter;
import com.lhh.amazon.common.RowCallBackHandler;
import com.lhh.amazon.dao.IUserDao;
import com.lhh.amazon.entity.User;

public class UserDaoImpl implements IUserDao {

	// 插入数据
	@Override
	public User insert(Connection conn, User user) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		// 查询SQL语句 注意序列名字
		String selectSQL = "select SEQ_USER.nextval from dual";
		jt.query(selectSQL, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					user.setUserID(rs.getLong(1));
				}
			}
		});

		// 插入SQL语句
		String insertSQL = "insert into hwua_user values(?,?,?,?,?,?,?,?,?,?)";
		jt.update(insertSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, user.getUserID());
				pstmt.setString(2, user.getUsername());
				pstmt.setString(3, user.getPassword());
				pstmt.setByte(4, user.getSex());
				// 强转
				pstmt.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
				pstmt.setString(6, user.getIdentityCode());
				pstmt.setString(7, user.getEmail());
				pstmt.setString(8, user.getMobile());
				pstmt.setString(9, user.getAddress());
				pstmt.setInt(10, user.getStatus());
			}
		});
		return user;
	}

	// 查询数据
	@Override
	public User select(Connection conn, String username, String password) throws DataAccessException {

		JdbcTemplate jt = new JdbcTemplate(conn);
		User user = new User();
		// 查询SQL语句
		String sql = "select * from hwua_user where hu_user_name = ? and hu_password = ?";
		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, username);
				pstmt.setString(2, password);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					user.setUserID(rs.getLong(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setSex(rs.getByte(4));
					user.setBirthday(rs.getDate(5));
					user.setIdentityCode(rs.getString(6));
					user.setEmail(rs.getString(7));
					user.setMobile(rs.getString(8));
					user.setAddress(rs.getString(9));
					user.setStatus(rs.getInt(10));
				}
			}
		});

		return user;
	}

	// 查询数据 通过姓名来查询
	@Override
	public User select(Connection conn, String username) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		User user = new User();
		// 查询SQL语句
		String sql = "select * from hwua_user where hu_user_name = ?";
		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, username);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					user.setUserID(rs.getLong(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setSex(rs.getByte(4));
					user.setBirthday(rs.getDate(5));
					user.setIdentityCode(rs.getString(6));
					user.setEmail(rs.getString(7));
					user.setMobile(rs.getString(8));
					user.setAddress(rs.getString(9));
					user.setStatus(rs.getInt(10));
				}
			}
		});
		return user;
	}

	//
	@Override
	public User select(Connection conn, String username, String phone, String email) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);
		User user = new User();
		// 查询SQL语句
		String sql = "select * from hwua_user where hu_user_name = ? and hu_mobile = ? and hu_email = ?";
		jt.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, username);
				pstmt.setString(2, phone);
				pstmt.setString(3, email);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					user.setUserID(rs.getLong(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setSex(rs.getByte(4));
					user.setBirthday(rs.getDate(5));
					user.setIdentityCode(rs.getString(6));
					user.setEmail(rs.getString(7));
					user.setMobile(rs.getString(8));
					user.setAddress(rs.getString(9));
					user.setStatus(rs.getInt(10));
				}
			}
		});
		return user;
	}

	// 更新信息
	@Override
	public void update(User user, Connection conn) throws DataAccessException {
		JdbcTemplate jt = new JdbcTemplate(conn);

		String sql = "update hwua_user "
				+ "set HU_USER_NAME = ?,HU_PASSWORD = ?,HU_SEX = ?,HU_BIRTHDAY = ?,HU_IDENTITY_CODE = ?,HU_EMAIL = ?,HU_MOBILE = ?,HU_ADDRESS = ?,HU_STATUS = ? "
				+ "where HU_USER_ID = ?";

		jt.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setByte(3, user.getSex());
				pstmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
				pstmt.setString(5, user.getIdentityCode());
				pstmt.setString(6, user.getEmail());
				pstmt.setString(7, user.getMobile());
				pstmt.setString(8, user.getAddress());
				pstmt.setInt(9, user.getStatus());
				pstmt.setLong(10, user.getUserID());
			}
		});
	}
}
