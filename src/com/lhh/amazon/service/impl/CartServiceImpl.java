package com.lhh.amazon.service.impl;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.ConnectionFactory;
import com.lhh.amazon.common.DBUtils;
import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.dao.ICartDao;
import com.lhh.amazon.dao.impl.CartDaoImpl;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.service.ICartService;

public class CartServiceImpl implements ICartService {

	private ICartDao dao;

	public CartServiceImpl() {
		dao = new CartDaoImpl();
	}

	// 创建一个购物车
	@Override
	public Cart createCart(Cart cart) throws ServiceException {
		Connection conn;
		conn = ConnectionFactory.getConnection();
		try {
			cart = dao.insert(conn, cart);
		} catch (DataAccessException e) {
			throw new ServiceException("添加失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return cart;
	}

	// 结算账单之后删除购物车
	@Override
	public void deleteCart(Long id) throws ServiceException {

		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		try {
			dao.delete(id, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("删除失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
	}

	// 清空购物车
	@Override
	public void deleteAllCart(Long userid) throws ServiceException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		try {
			dao.deleteAll(userid, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("删除失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
	}

	// 更新购买商品的数量
	@Override
	public void updateCart(Long pID, Long userID, int quantity) throws ServiceException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		try {
			dao.update(pID, userID, quantity, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("更新失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
	}

	@Override
	public void updateCart(Long id, int quantity) throws ServiceException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		try {
			dao.update(id, quantity, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("更新失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
	}

	@Override
	public List<Cart> showCart(Long userid) throws ServiceException {

		Connection conn;
		conn = ConnectionFactory.getConnection();
		List<Cart> list;
		try {
			list = dao.select(userid, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("查找失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return list;
	}
}
