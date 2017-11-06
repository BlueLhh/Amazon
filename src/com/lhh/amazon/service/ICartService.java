package com.lhh.amazon.service;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;

public interface ICartService {
	// 创建一个购物车
	public Cart createCart(Cart cart) throws ServiceException;

	// 更新数据（当数量发生变化的时候） 在商品页添加的时候使用的方法
	public void updateCart(Long pID, Long userID, int quantity) throws ServiceException;

	// 根据购物车的ID来进行更新 在购物车内添加的时候使用的方法
	public void updateCart(Long id, int quantity) throws ServiceException;

	// 删除购物车
	public void deleteCart(Long id) throws ServiceException;

	// 当结算的时候删除购物车内该用户所有的信息
	public void deleteAllCart(Long userid) throws ServiceException;

	// 查询用户在购物车内的全部商品信息
	public List<Cart> showCart(Long userid) throws ServiceException;

	// 通过商品的ID和用户的ID来查询数据库中是否存在该信息
	public boolean checkCart(Long pid, Long userid) throws ServiceException;

	public Cart findCart(Long pid, Long userid) throws ServiceException;
}
