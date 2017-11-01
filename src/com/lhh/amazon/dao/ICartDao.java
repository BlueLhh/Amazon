package com.lhh.amazon.dao;

import java.sql.Connection;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.entity.Cart;

public interface ICartDao {
	/**
	 * 新增购物车
	 * 
	 * @param conn
	 * @param cart
	 * @return
	 * @throws DataAccessException
	 */
	public Cart insert(Connection conn, Cart cart) throws DataAccessException;

	/**
	 * 删除购物车， 结算的时候删除
	 * 
	 * @param conn
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public void delete(Long id, Connection conn) throws DataAccessException;
}
