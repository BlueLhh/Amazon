package com.lhh.amazon.dao.impl;

import java.sql.Connection;

import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.dao.ICartDao;
import com.lhh.amazon.entity.Cart;

public class CartDaoImpl implements ICartDao {

	// 创建一个购物车
	@Override
	public Cart insert(Connection conn, Cart cart) throws DataAccessException {
		return null;
	}

	// 删除 结算之后删除购物车
	@Override
	public void delete(Long id, Connection conn) throws DataAccessException {

	}

}
