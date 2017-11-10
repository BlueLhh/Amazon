package com.lhh.amazon.dao;

import java.sql.Connection;
import java.util.List;

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

	// 根据用户名字来删除
	public void deleteAll(Long userid, Connection conn) throws DataAccessException;

	/**
	 * 更新数据（数量）
	 * 
	 * @param quantity
	 * @param conn
	 * @return
	 * @throws DataAccessException
	 */
	public void update(Long pid, Long userID, int quantity, Connection conn) throws DataAccessException;

	public void update(Long id, int quantity, Connection conn) throws DataAccessException;

	// 显示当前用户全部的购物车信息
	public List<Cart> select(Long userid, Connection conn) throws DataAccessException;

	// 通过用户ID和商品的ID进行查询数据表里是否存在该数据
	public Cart select(Long pid, Long userid, Connection conn) throws DataAccessException;

	// 通过购物车的ID进行查询购物车的信息
	public Cart selectOne(Long id, Connection conn) throws DataAccessException;

}
