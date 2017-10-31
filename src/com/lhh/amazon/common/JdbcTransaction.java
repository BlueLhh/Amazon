package com.lhh.amazon.common;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTransaction {
	
	public void beginTransaction(Connection conn){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("begin transaction failed");
			e.printStackTrace();
		}
	}
	
	public void commit(Connection conn){
		try {
			conn.commit();
		} catch (SQLException e) {
			System.out.println("commit transaction failed");
			e.printStackTrace();
		}
	}
	
	public void rollback(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			System.out.println("rollback transaction failed");
			e.printStackTrace();
		}
	}
	
	
}
